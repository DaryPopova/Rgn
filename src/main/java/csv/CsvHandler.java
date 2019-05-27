package csv;

import models.Has;
import models.ObjectTools;
import models.entities.Entity;
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
                    } else {
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

    String path = "C:\\Users\\padre\\Dropbox\\edu\\Rgn\\src\\main\\resources";

    private String getFileName(String path, Integer nestingLevel){
        return String.format(path + "_%s_" + "_%s" + ".csv" , nestingLevel.toString(), System.currentTimeMillis());
    }

    public void writeEntitiesToCsv(ArrayList<Entity> entities) throws Exception {
        Map<Integer, FileWriter> nestingLevelToFileWriter = new HashMap<>();

        writeByLevel(entities, nestingLevelToFileWriter, 0);
        for(FileWriter writer: nestingLevelToFileWriter.values()) {
            writer.close();
        }
    }

    private void writeByLevel(ArrayList<Entity> entities,
                              Map<Integer, FileWriter> nestingLevelToFileWriter,
                              Integer nestingLevel) throws Exception {
        if (nestingLevelToFileWriter.get(nestingLevel) == null) {
            nestingLevelToFileWriter.put(nestingLevel, new FileWriter(new File(getFileName(path, nestingLevel))));
        }
        FileWriter writer = nestingLevelToFileWriter.get(nestingLevel);
        for (Entity entity : entities) {
            for (Field field : entity.getClass().getDeclaredFields()) {
                switch (ObjectTools.getTypeKind(field)) {
                    case PRIMITIVE:
                    case STRING: {
                        if (field.get(entity) == null) {
                            writer.append("");
                        } else {
                            writer.append(field.get(entity).toString());
                        }
                        writer.append(",");
                        break;
                    }
                    case COLLECTION: {
                        writeByLevel(getNestedEntities(field, entity), nestingLevelToFileWriter, nestingLevel + 1);
                        break;
                    }
                    case COMPLEX:
                        throw new Exception("Extracting of complex type don't support");
                }
                writer.append("\n");
            }
        }
    }

    private ArrayList<Entity> getNestedEntities(Field field, Entity entity) {
        ArrayList<Entity> innerEntities = new ArrayList<>();
        try {
            innerEntities = (ArrayList<Entity>) getObject(field, entity);
        } catch (ClassCastException e) {
            System.out.println("Can not cast to ArrayList<Entity>");
        }
        return innerEntities;
    }


}