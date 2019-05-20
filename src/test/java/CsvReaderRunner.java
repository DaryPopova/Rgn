import csv.CsvHandler;
import models.entities.Employee;
import org.junit.jupiter.api.Test;

public class CsvReaderRunner {

    @Test
    public void runReadCsv() throws Exception {
        new CsvHandler().readCsvToListOfEntities(Employee.class,
                "C:\\Users\\padre\\Downloads\\part-00000-82627f3f-3dc5-4248-b2c8-a3be01166c22-c000.csv");
    }
}