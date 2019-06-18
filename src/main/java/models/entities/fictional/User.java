package models.entities.fictional;

import csv.Column;
import models.Has;
import models.entities.Entity;

import java.util.List;

public class User extends Entity {

    @Column(name = "id")
    public Integer id;
    @Column(name = "name")
    public String name;
    @Column(name = "age")
    public Integer age;
    @Has(pairsOfParentAndChildFields = "userId|id")
    public List<Auto> autos;
}