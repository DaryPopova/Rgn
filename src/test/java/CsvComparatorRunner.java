import csv.CsvComparator;
import org.junit.Test;

import java.io.IOException;

public class CsvComparatorRunner {
    @Test
    public void run() throws IOException {
        CsvComparator comparator = new CsvComparator();
        String path = "C:\\Users\\padre\\Downloads\\Microsoft.SkypeApp_kzf8qxf38zg5c!App\\All\\минимальный набор из реальных данных\\";
        comparator.compareCsvFiles(path + "src/businessaccount.csv",
                path + "_0_BusinessAccount_1559132830829.csv",
                path + "diff_business.txt");
        comparator.compareCsvFiles(path + "personaccount.csv",
                path + "_1_PersonAccount_1559132830834.csv",
                path + "diff_person.txt");
    }

}
