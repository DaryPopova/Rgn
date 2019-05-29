package csv;

import models.ObjectTools;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static models.ObjectTools.getObject;
import static models.ObjectTools.toTypeWithValue;

public class CsvHandler {

    public ArrayList readCsvToListOfEntities(Class typeOfEntity, String path) throws Exception {
        ArrayList listOfEntities = new ArrayList<>();
        FileInputStream is = new FileInputStream(path);
        Reader in = new InputStreamReader(is);
        CSVParser parser = new CSVParser(in, CSVFormat.RFC4180);
        List<CSVRecord> csvRecords = parser.getRecords();
        for (int i = 1; i < csvRecords.size(); i++) {
            Object entity = typeOfEntity.newInstance();
            for (int j = 0; j < csvRecords.get(i).size(); j++) {
                for (Field field : typeOfEntity.getDeclaredFields()) {
                    if (getColumnName(field) != null) {
                        if (csvRecords.get(0).get(j).equals(getColumnName(field))) {
                            field.set(entity, toTypeWithValue(field.getType(), csvRecords.get(i).get(j)));
                        }
                    }
                }
            }
            listOfEntities.add(entity);
        }
        return listOfEntities;
    }

    private String getColumnName(Field field) {
        Annotation annotation = field.getAnnotation(Column.class);
        Column columnAnnotation = (Column) annotation;
        if (columnAnnotation == null) {
            return null;
        } else return columnAnnotation.name();
    }

    String path = "C:\\Users\\padre\\Downloads\\Microsoft.SkypeApp_kzf8qxf38zg5c!App\\All\\минимальный набор из реальных данных\\";

    private String getFileName(String path, Integer nestingLevel, Class classOfEntity){
        return String.format(path + "_%s" + "_%s" + "_%s" + ".csv" , nestingLevel.toString(), classOfEntity.getSimpleName(), System.currentTimeMillis());
    }

    public void writeEntitiesToCsv(ArrayList entities) throws Exception {
        Map<Integer, Map<Class, FileWriter>> nestingLevelToFileWriter = new HashMap<>();

        writeByLevel(entities, nestingLevelToFileWriter, 0);
        for (Map<Class, FileWriter> kindOfEntityToFileWriter: nestingLevelToFileWriter.values()) {
            for(FileWriter writer: kindOfEntityToFileWriter.values()) {
                writer.close();
            }
        }
    }

    private void writeByLevel(ArrayList entities,
                              Map<Integer, Map<Class, FileWriter>> nestingLevelToFileWriters,
                              Integer nestingLevel) throws Exception {
        if (nestingLevelToFileWriters.get(nestingLevel) == null) {
            Map<Class, FileWriter> kindOfEntityToFileWriter = new HashMap<>();
            nestingLevelToFileWriters.put(nestingLevel, kindOfEntityToFileWriter);
        }
        for (Object entity : entities) {
            if (nestingLevelToFileWriters.get(nestingLevel).get(entity.getClass()) == null) {
                nestingLevelToFileWriters.get(nestingLevel).put(entity.getClass(),
                        new FileWriter(new File(getFileName(path, nestingLevel, entity.getClass()))));
            }
            FileWriter writer = nestingLevelToFileWriters.get(nestingLevel).get(entity.getClass());
            for (Field field : entity.getClass().getDeclaredFields()) {
                switch (ObjectTools.getTypeKind(field)) {
                    case PRIMITIVE:
                    case STRING: {
                        writer.append("\"");
                        if (field.get(entity) == null) {
                            writer.append("");
                        } else {
                            writer.append(field.get(entity).toString());
                        }
                        writer.append("\"");
                        writer.append(",");
                        break;
                    }
                    case COLLECTION: {
                        writeByLevel(getNestedEntities(field, entity), nestingLevelToFileWriters, nestingLevel + 1);
                        break;
                    }
                    case COMPLEX:
                        throw new Exception("Extracting of complex type don't support");
                }
            }
            writer.append("\n");
        }
    }

    private ArrayList getNestedEntities(Field field, Object entity) {
        ArrayList innerEntities = new ArrayList<>();
        try {
            innerEntities = (ArrayList) getObject(field, entity);
        } catch (ClassCastException e) {
            System.out.println("Can not cast to ArrayList<Entity>");
        }
        return innerEntities;
    }
}