package readers;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;

import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

public interface CsvObject extends Serializable {
    long serialVersionUID = 1L;
    ColumnPositionMappingStrategy setColumnMapping();
    String toString();

    @SuppressWarnings({"rawtypes", "unchecked"})
    default void readCsvToObject(String csvFilename) throws IOException {
        CsvToBean csv = new CsvToBean();
        CSVReader csvReader = new CSVReader(new FileReader(csvFilename));
        //Set column mapping strategy
        List list = csv.parse(this.setColumnMapping(), csvReader);
        for (Object object : list) {
            CsvObject csvObject = (CsvObject) object;
            System.out.println(csvObject);
        }
    }
}