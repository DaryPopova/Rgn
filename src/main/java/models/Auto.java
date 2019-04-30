package models;

import javax.persistence.*;

@Entity
@Table(name = "autos")
public class Auto extends DataAccessObject {

    @Id
    public int id;

    @Column (name = "model")
    public String model;

    //можно не указывать Column name, если оно совпадает с названием столбца в таблице
    public String color;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    public User user;

    public Auto() {
    }

    public Auto(Integer id, String model, String color) {
        this.id = id;
        this.model = model;
        this.color = color;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}