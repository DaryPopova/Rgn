package models;

import java.util.ArrayList;
import java.util.List;

@Reflectable(name="reflectable",  value = "какие-то метаданные")
public class User extends DataAccessObject {

    public Integer id;

    @Reflectable2(name="reflectable2",  value = "какие-то метаданные2")
    public String name;
    //можно не указывать Column name, если оно совпадает с названием столбца в таблице
    public int age;

    public List<Auto> autos;

    public FullName fullName;

    public User() {
        autos = new ArrayList<Auto>();
    }

    public User(Integer id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
        autos = new ArrayList<Auto>();
    }

    @Reflectable1(name="reflectable1",  value = "какие-то метаданные1")
    public void addAuto(Auto auto) {
        autos.add(auto);
        auto.setUser(this);
    }

    public void removeAuto(Auto auto) {
        autos.remove(auto);
    }

    public List<Auto> getAutos() {
        return autos;
    }

    public void setAutos(List<Auto> autos) {
        this.autos = autos;
    }

}