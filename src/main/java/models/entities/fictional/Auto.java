package models.entities.fictional;

import csv.Column;
import database.DbField;
import models.Has;
import models.entities.Entity;

import java.util.List;

public class Auto extends Entity {
    @Column(name = "id")
    public Integer id;
    @Column(name = "model")
    public String model;
    @Column(name = "color")
    public String color;
    @Column(name = "user_id")
    public Integer userId;
    @Has(childFieldName = "autoId", parentFieldName = "id")
    public List<Seller> sellers;
    @Has(childFieldName = "autoId", parentFieldName = "id")
    public List<Owner> owners;
}