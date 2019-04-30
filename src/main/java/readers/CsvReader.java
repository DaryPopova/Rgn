package readers;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

public class CsvReader {
    public static void main(String[] args) throws Exception {
        FileInputStream is = new FileInputStream(
                "/home/degu/Downloads/part-00000-82627f3f-3dc5-4248-b2c8-a3be01166c22-c000.csv");

        Reader in = new InputStreamReader(is);
        CSVParser parser = new CSVParser(in, CSVFormat.RFC4180);
        List<CSVRecord> list = parser.getRecords();
        System.out.println(list.get(11).get(2));
    }
}
