import database.DatabaseReader;
import models.EntitiesBuilder;
import models.Logger;
import models.entities.semarchy.SdOrgExtIdentifier;
import models.entities.semarchy.SdOrganization;
import org.junit.Test;

import java.sql.Connection;
import java.util.ArrayList;

public class ReadSemarchyDb {
    @Test
    public void run() throws Exception {
        DatabaseReader databaseReader = new DatabaseReader();
        Connection connection = databaseReader.createConnection("org.postgresql.Driver",
                "jdbc:postgresql://localhost:5432/postgres","postgres","postgres");

        ArrayList sdOrganizations = databaseReader.executeSelect(connection, SdOrganization.class, "semarchy_dloc2.sd_organization");
        ArrayList sdOrgExtIdentifiers = databaseReader.executeSelect(connection, SdOrgExtIdentifier.class, "semarchy_dloc2.sd_org_ext_identifier");
        EntitiesBuilder builder = new EntitiesBuilder();
        builder.buildEntities(sdOrganizations, sdOrgExtIdentifiers);
        for (Object entity: sdOrganizations) {
            Logger.log(entity);
        }
    }
}
