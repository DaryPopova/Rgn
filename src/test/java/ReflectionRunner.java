import models.Logger;
import models.entities.fictional.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class ReflectionRunner {

    @Test
    public void exploreFields() throws IllegalAccessException {
        User user = new User();
        user.id = 1;
        user.name = "Ddff";
        user.age = 24;

        Auto ferrari = new Auto();
        ferrari.id = 3;
        ferrari.model = "Ferrari";
        ferrari.color = "red";

        ferrari.owners = new ArrayList<>();
        Owner owner = new Owner();
        owner.id = 23;
        owner.name = "Aaaaa";
        Owner owner1 = new Owner();
        owner1.id = 24;
        owner1.name = "Sssss";
        ferrari.owners.add(owner);
        ferrari.owners.add(owner1);
        Auto ford = new Auto();
        ford.id = 2;
        ford.model = "Ford";
        ford.color = "black";

        Owner owner2 = new Owner();
        owner2.id = 25;
        owner2.name = "Ddddd";
        Owner owner3 = new Owner();
        owner3.id = 26;
        owner3.name = "Fffff";
        ford.owners.add(owner2);
        ford.owners.add(owner3);


        User user1 = new User();
        user1.id = 11;
        user1.name = "1Ddff";
        user1.age = 124;

        Auto ferrari1 = new Auto();
        ferrari1.id = 13;
        ferrari1.model = "1Ferrari";
        ferrari1.color = "1red";

        Owner owner4 = new Owner();
        owner4.id = 27;
        owner4.name = "Gggg";
        Owner owner5 = new Owner();
        owner5.id = 28;
        owner5.name = "Hhhh";
        ferrari1.owners.add(owner4);
        ferrari1.owners.add(owner5);
        Auto ford1 = new Auto();
        ford1.id = 2;
        ford1.model = "Ford";
        ford1.color = "black";

        Owner owner6 = new Owner();
        owner6.id = 29;
        owner6.name = "Jjjj";
        Owner owner7 = new Owner();
        owner7.id = 30;
        owner7.name = "Kkkk";
        ferrari1.owners.add(owner6);
        ferrari1.owners.add(owner7);

        Logger.log(user);
        Logger.log(user1);
    }
}