import database.DatabaseReader;
import models.EntitiesBuilder;
import models.Logger;
import models.entities.fictional.Auto;
import models.entities.fictional.User;
import models.entities.veeva.BusinessAccount;
import models.entities.veeva.PersonAccount;
import org.junit.Test;

import java.util.ArrayList;

public class DatabaseRead {
    @Test
    public void run() throws Exception {
        DatabaseReader databaseReader = new DatabaseReader();

        ArrayList businessAccounts = databaseReader.executeSelect(BusinessAccount.class, "landing_area.businessaccount");
        ArrayList personAccounts = databaseReader.executeSelect(PersonAccount.class, "landing_area.personaccount");
        EntitiesBuilder builder = new EntitiesBuilder();
        builder.buildEntities(businessAccounts, personAccounts);
        for (Object entity: businessAccounts) {
            Logger.log(entity);
        }
    }
}
