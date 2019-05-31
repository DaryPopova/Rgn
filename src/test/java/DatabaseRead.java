import database.DatabaseReader;
import models.EntitiesBuilder;
import models.Logger;
import models.entities.fictional.Auto;
import models.entities.fictional.User;
import org.junit.Test;

import java.util.ArrayList;

public class DatabaseRead {
    @Test
    public void run() throws Exception {
        DatabaseReader databaseReader = new DatabaseReader();
        ArrayList users = databaseReader.executeSelect(User.class, "users");
        ArrayList autos = databaseReader.executeSelect(Auto.class, "autos");
        EntitiesBuilder builder = new EntitiesBuilder();
        builder.buildEntities(users, autos);
        for (Object entity: users) {
            Logger.log(entity);
        }
    }
}
