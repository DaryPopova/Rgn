package models.entities.fictional;

import models.Has;
import models.entities.Entity;

import java.util.List;

public class Auto extends Entity {

    public Integer id;
    public String model;
    public String color;
    public Integer userId;
    @Has(childFieldName = "autoId", parentFieldName = "id")
    public List<Seller> sellers;
    @Has(childFieldName = "autoId", parentFieldName = "id")
    public List<Owner> owners;
}