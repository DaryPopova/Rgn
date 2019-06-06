package models.entities.fictional;

import csv.Column;
import models.entities.Entity;

public class Seller extends Entity {
    public Integer id;
    public String name;
    @Column(name = "auto_id")
    public Integer autoId;
}
