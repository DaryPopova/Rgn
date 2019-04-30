package models;

public class DbRunner {
    public static void main(String[] args) {
       // User user = new User(){{id = 12; name = "Masha"; age = 26;}};
        User user = new User();
        user.id = 1;

        //User user = new User(12, "Mashs", 26);

        user.save();
        Auto ferrari = new Auto(){{id = 1; model = "Ferrari"; color = "red";}};
        //Auto ferrari = new Auto(1,"Ferrari", "red");

        ferrari.setUser(user);
        user.addAuto(ferrari);
        Auto ford = new Auto(){{id = 2; model = "Ford"; color = "black";}};
        //Auto ford = new Auto(2,"Ford", "black");

        ford.setUser(user);
        user.addAuto(ford);
        Auto bmw = new Auto(){{id = 3; model = "BMW"; color = "gold";}};
        //Auto bmw = new Auto(3,"BMW", "gold");

        bmw.save();
        user.update();
    }
}
