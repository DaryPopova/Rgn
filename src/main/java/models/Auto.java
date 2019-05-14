package models;

public class Auto extends DataAccessObject {

    public Integer id;

    public String model;

    //можно не указывать Column name, если оно совпадает с названием столбца в таблице
    public String color;

    @Nonreflectable
    public User user;

    public Auto() {
    }

    public Auto(Integer id, String model, String color) {
        this.id = id;
        this.model = model;
        this.color = color;
    }

    public void setUser(User user) {
        this.user = user;
    }
}