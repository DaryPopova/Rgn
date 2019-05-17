
import csv.CsvHandler;
import csv.Employee;
import csv.Entity;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CsvWriterRunner {
    @Test
    public void runWriteCsv() throws Exception {
        ArrayList<Entity> entities = new ArrayList<>();
        Employee employee1 = new Employee();
        employee1.recordNumber = 1;
        employee1.inboundLastName = "Name1";
        Employee employee2 = new Employee();
        employee2.recordType = 22;
        employee2.inboundLastName = "Name2";
        Employee employee3 = new Employee();
        employee3.recordType = 33;
        employee3.recordNumber = 3;
        entities.add(employee1);
        entities.add(employee2);
        entities.add(employee3);

        new CsvHandler().writeEntitiesToCsv(entities,
                "C:\\Users\\padre\\Downloads\\part.csv");
    }
}
