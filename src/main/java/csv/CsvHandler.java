package csv;

import models.entities.Entity;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

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
                for (Field field: typeOfEntity.getDeclaredFields()) {
                    if (csvRecords.get(0).get(j).equals(getColumnName(field))) {
                        field.set(entity, toTypeWithValue(field.getType(), csvRecords.get(i).get(j)));
                    }
                }
            }
            listOfEntities.add(entity);
        }
        System.out.println(listOfEntities);
        return listOfEntities;
    }

    private String getColumnName(Field field) {
        Annotation annotation = field.getAnnotation(Column.class);
        Column columnAnnotation = (Column) annotation;
        return columnAnnotation.name();
    }

    public void writeEntitiesToCsv(ArrayList<Entity> entities, String path) throws Exception {
        FileWriter writer = new FileWriter(path);
        for (Entity entity: entities) {
            for (Field field: entity.getClass().getDeclaredFields()) {
                if (field.get(entity) == null) {
                    writer.append("");
                } else {
                    writer.append(field.get(entity).toString());
                }
                writer.append(",");
            }
            writer.append("\n");
        }
        writer.close();
    }
}