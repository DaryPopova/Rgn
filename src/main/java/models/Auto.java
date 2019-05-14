package models;

public class Auto extends Entity {

    public Integer id;
    public String model;
    public String color;
    @NonReflectable
    public User user;

    public Auto() {
    }

    public void setUser(User user) {
        this.user = user;
    }
}