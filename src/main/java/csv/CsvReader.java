package csv;

import models.ParentOwner;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static models.ObjectTools.getColumnName;
import static models.ObjectTools.toTypeWithValue;

public class CsvReader {
    public ArrayList readCsvToListOfEntities(Class typeOfEntity, String path) throws Exception {
        ArrayList listOfEntities = new ArrayList<>();
        FileInputStream is = new FileInputStream(path);
        Reader in = new InputStreamReader(is);
        CSVParser parser = new CSVParser(in, CSVFormat.RFC4180);
        List<CSVRecord> csvRecords = parser.getRecords();
        CSVRecord csvFields = csvRecords.get(0);
        for (int i = 1; i < csvRecords.size(); i++) {
            Object entity = typeOfEntity.newInstance();
            setValuesToFieldsOfEntity(csvFields, entity, csvRecords.get(i));
            initializeParentOwnerOfEntity(entity);
            listOfEntities.add(entity);
        }
        return listOfEntities;
    }

    private void setValuesToFieldsOfEntity(CSVRecord csvFields, Object entity, CSVRecord csvRaw) throws Exception {
        for (int j = 0; j < csvRaw.size(); j++) {
            for (Field field : entity.getClass().getDeclaredFields()) {
                if (getColumnName(field) != null) {
                    if (csvFields.get(j).equals(getColumnName(field))) {
                        field.set(entity, toTypeWithValue(field.getType(), csvRaw.get(j)));
                    }
                }
            }
        }
    }

    private void initializeParentOwnerOfEntity(Object entity) throws Exception {
        for (Field field: entity.getClass().getFields()) {
            if (field.getAnnotation(ParentOwner.class) != null) {
                field.set(entity, null);
            }
        }
    }
}