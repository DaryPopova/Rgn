import database.DatabaseReader;
import models.EntitiesBuilder;
import models.Logger;
import models.entities.veeva.BusinessAccount;
import models.entities.veeva.PersonAccount;
import org.junit.Test;

import java.sql.Connection;
import java.util.ArrayList;

public class ReadRealDb {
    @Test
    public void run() throws Exception {
        DatabaseReader databaseReader = new DatabaseReader();
        Connection connection = databaseReader.createConnection("org.postgresql.Driver",
                "jdbc:postgresql://localhost:5432/postgres","postgres","postgres");

        ArrayList businessAccounts = databaseReader.executeSelect(connection, BusinessAccount.class, "landing_area.businessaccount");
        ArrayList personAccounts = databaseReader.executeSelect(connection, PersonAccount.class, "landing_area.personaccount");
        EntitiesBuilder builder = new EntitiesBuilder();
        builder.buildEntities(businessAccounts, personAccounts);
        for (Object entity: businessAccounts) {
            Logger.log(entity);
        }
    }
}
