package models.entities.fictional;

import models.NonReflectable;
import models.entities.Entity;

import java.util.ArrayList;
import java.util.List;

public class Auto extends Entity {

    public Integer id;
    public String model;
    public String color;
    @NonReflectable
    public User user;
    public Seller seller;
    public List<Owner> owners;

    public Auto() {
        owners = new ArrayList<>();
    }

    public void setUser(User user) {
        this.user = user;
    }
}