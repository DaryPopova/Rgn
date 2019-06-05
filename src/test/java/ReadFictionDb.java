import database.DatabaseReader;
import models.EntitiesBuilder;
import models.Logger;
import models.entities.fictional.Auto;
import models.entities.fictional.User;

import org.junit.Test;

import java.sql.Connection;
import java.util.ArrayList;

public class ReadFictionDb {
    @Test
    public void run() throws Exception {
        DatabaseReader databaseReader = new DatabaseReader();
        Connection connection = databaseReader.createConnection("org.postgresql.Driver",
                "jdbc:postgresql://localhost:5432/postgres","postgres","1234");

        ArrayList users = databaseReader.executeSelect(connection, User.class, "users");
        ArrayList autos = databaseReader.executeSelect(connection, Auto.class, "autos");
        EntitiesBuilder builder = new EntitiesBuilder();
        builder.buildEntities(users, autos);
        for (Object entity: users) {
            Logger.log(entity);
        }
    }
}
