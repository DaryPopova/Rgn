import models.Auto;
import models.FullName;
import models.User;
import org.junit.jupiter.api.Test;

public class ReflectionRunner {

    @Test
    public void exploreFields() throws IllegalAccessException {
        User user = new User();
        user.id = 1;
        user.name = "Ddff";
        user.age = 24;
        user.fullName = new FullName();
        user.fullName.longName = "Qqqq";
        user.fullName.secondName = "Wwww";
        user.fullName.surname = "Eeee";
        Auto ferrari = new Auto();
        ferrari.id = 3;
        ferrari.model = "Ferrari";
        ferrari.color = "red";
        user.addAuto(ferrari);
        Auto ford = new Auto();
        ford.id = 2;
        ford.model = "Ford";
        ford.color = "black";
        user.addAuto(ford);
        Logger.log(user);
    }
}