import csv.CsvReader;
import csv.Extractor;
import models.EntitiesBuilder;
import models.entities.Entity;
import models.entities.veeva.BusinessAccount;
import models.entities.veeva.PersonAccount;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static models.Logger.log;

public class CsvReaderRunner {

    @Test
    public void runReadCsv() throws Exception {
        CsvReader csvReader = new CsvReader();
        ArrayList<BusinessAccount> businessAccounts = csvReader.readCsvToListOfEntities(BusinessAccount.class,
                "C:\\Users\\padre\\Downloads\\Microsoft.SkypeApp_kzf8qxf38zg5c!App\\All\\минимальный набор из реальных данных\\businessaccount.csv");
        ArrayList<PersonAccount> personAccounts = csvReader.readCsvToListOfEntities(PersonAccount.class,
                "C:\\Users\\padre\\Downloads\\Microsoft.SkypeApp_kzf8qxf38zg5c!App\\All\\минимальный набор из реальных данных\\personaccount.csv");

        EntitiesBuilder builder = new EntitiesBuilder();
        builder.buildEntities(businessAccounts, personAccounts);
        for (Entity businessAccount: businessAccounts) {
            log(businessAccount);
        }
    }
}