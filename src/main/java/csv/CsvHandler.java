package csv;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class CsvHandler {
    public <T> ArrayList<T> readCsvToListOfEntities(String path) throws IOException {
        ArrayList<T> listOfEntities = new ArrayList<>();
        FileInputStream is = new FileInputStream(path);
        Reader in = new InputStreamReader(is);
        CSVParser parser = new CSVParser(in, CSVFormat.RFC4180);
        List<CSVRecord> csvRecords = parser.getRecords();
        for (CSVRecord csvRecord: csvRecords) {
            for (Object o: csvRecord) {

            }
        }
        return listOfEntities;
    }

    public void writeEntitiesToCsv(ArrayList<Entity> entities) {

    }
}
