
import csv.CsvHandler;
import models.entities.Entity;
import models.entities.fictional.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CsvWriterRunner {
    @Test
    public void runWriteCsv() throws Exception {
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
        ferrari.seller = new Seller();
        ferrari.seller.id = 12;
        ferrari.seller.name = "SellerOne";
        ferrari.owners = new ArrayList<>();
        Owner owner = new Owner();
        owner.id = 23;
        owner.name = "Aaaaa";
        Owner owner1 = new Owner();
        owner1.id = 24;
        owner1.name = "Sssss";
        ferrari.owners.add(owner);
        ferrari.owners.add(owner1);
        user.addAuto(ferrari);
        Auto ford = new Auto();
        ford.id = 2;
        ford.model = "Ford";
        ford.color = "black";
        ford.seller = new Seller();
        ford.seller.id = 14;
        ford.seller.name = "SellerTwo";
        Owner owner2 = new Owner();
        owner2.id = 25;
        owner2.name = "Ddddd";
        Owner owner3 = new Owner();
        owner3.id = 26;
        owner3.name = "Fffff";
        ford.owners.add(owner2);
        ford.owners.add(owner3);
        user.addAuto(ford);


        User user1 = new User();
        user1.id = 11;
        user1.name = "1Ddff";
        user1.age = 124;
        user1.fullName = new FullName();
        user1.fullName.longName = "1Qqqq";
        user1.fullName.secondName = "1Wwww";
        user1.fullName.surname = "1Eeee";
        Auto ferrari1 = new Auto();
        ferrari1.id = 13;
        ferrari1.model = "1Ferrari";
        ferrari1.color = "1red";
        ferrari1.seller = new Seller();
        ferrari1.seller.id = 112;
        ferrari1.seller.name = "1SellerOne";
        Owner owner4 = new Owner();
        owner4.id = 27;
        owner4.name = "Gggg";
        Owner owner5 = new Owner();
        owner5.id = 28;
        owner5.name = "Hhhh";
        ferrari1.owners.add(owner4);
        ferrari1.owners.add(owner5);
        user1.addAuto(ferrari1);
        Auto ford1 = new Auto();
        ford1.id = 2;
        ford1.model = "Ford";
        ford1.color = "black";
        ford1.seller = new Seller();
        ford1.seller.id = 14;
        ford1.seller.name = "SellerTwo";
        Owner owner6 = new Owner();
        owner6.id = 29;
        owner6.name = "Jjjj";
        Owner owner7 = new Owner();
        owner7.id = 30;
        owner7.name = "Kkkk";
        ferrari1.owners.add(owner6);
        ferrari1.owners.add(owner7);
        user1.addAuto(ford1);

        ArrayList<Entity> users = new ArrayList<>();
        users.add(user);
        users.add(user1);

        new CsvHandler().writeEntitiesToCsv(users,
                "/home/degu/Dropbox/edu/Rgn/src/main/resources/");
    }
}
