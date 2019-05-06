package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "users")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class User extends DataAccessObject {

    @Id
    public int id;

    @Column(name = "name")
    public String name;
    //можно не указывать Column name, если оно совпадает с названием столбца в таблице
    public int age;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<Auto> autos;

    public User() {
        autos = new ArrayList<Auto>();
    }

    public User(Integer id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
        autos = new ArrayList<Auto>();
    }

    public void addAuto(Auto auto) {
        auto.setUser(this);
        autos.add(auto);
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