package models.entities.fictional;

import csv.Column;
import database.DbField;
import models.Has;
import models.Reflectable;
import models.Reflectable2;
import models.entities.Entity;

import java.util.List;

@Reflectable(name="reflectable",  value = "какие-то метаданные")
public class User extends Entity {

    @Column(name = "id")
    public Integer id;
    @Reflectable2(name="reflectable2",  value = "какие-то метаданные2")
    @Column(name = "name")
    public String name;
    @Column(name = "age")
    public Integer age;
    @Has(childFieldName = "userId", parentFieldName = "id")
    public List<Auto> autos;
}