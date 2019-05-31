package models.entities.fictional;

import database.DbField;
import models.entities.Entity;

public class Owner extends Entity {
    public Integer id;
    public String name;
    @DbField(name = "auto_id")
    public Integer autoId;
}
