package models.entities.fictional;

import database.DbField;
import models.Has;
import models.entities.Entity;

import java.util.List;

public class Auto extends Entity {
    @DbField(name = "id")
    public Integer id;
    @DbField(name = "model")
    public String model;
    @DbField(name = "color")
    public String color;
    @DbField(name = "user_id")
    public Integer userId;
    @Has(childFieldName = "autoId", parentFieldName = "id")
    public List<Seller> sellers;
    @Has(childFieldName = "autoId", parentFieldName = "id")
    public List<Owner> owners;
}