import csv.CsvHandler;
import models.EntitiesLinker;

import models.entities.Entity;
import models.entities.veeva.BusinessAccount;
import models.entities.veeva.PersonAccount;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static models.Logger.log;

public class VeevaPersonAndBusiness {
    @Test
    public void run() throws Exception {
        CsvHandler csvHandler = new CsvHandler();
        ArrayList<BusinessAccount> businessAccounts = csvHandler.readCsvToListOfEntities(BusinessAccount.class,
                "C:\\Users\\padre\\Downloads\\Microsoft.SkypeApp_kzf8qxf38zg5c!App\\All\\минимальный набор из реальных данных\\businessaccount.csv");
        ArrayList<PersonAccount> personAccounts = csvHandler.readCsvToListOfEntities(PersonAccount.class,
                "C:\\Users\\padre\\Downloads\\Microsoft.SkypeApp_kzf8qxf38zg5c!App\\All\\минимальный набор из реальных данных\\personaccount.csv");

        EntitiesLinker linker = new EntitiesLinker();
        linker.linkEntities(businessAccounts, personAccounts);
        for (Entity businessAccount: businessAccounts) {
            log(businessAccount);
        }
    }
}