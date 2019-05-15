package models.entities;

import models.Reflectable;
import models.Reflectable1;
import models.Reflectable2;

import java.util.ArrayList;
import java.util.List;

@Reflectable(name="reflectable",  value = "какие-то метаданные")
public class User extends Entity {

    public Integer id;
    @Reflectable2(name="reflectable2",  value = "какие-то метаданные2")
    public String name;
    public int age;
    public List<Auto> autos;
    public FullName fullName;

    public User() {
        autos = new ArrayList<>();
    }

    @Reflectable1(name="reflectable1",  value = "какие-то метаданные1")
    public void addAuto(Auto auto) {
        autos.add(auto);
        auto.setUser(this);
    }
}