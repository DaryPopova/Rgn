package models.entities.fictional;

import models.Has;
import models.Reflectable;
import models.Reflectable1;
import models.Reflectable2;
import models.entities.Entity;

import java.util.ArrayList;
import java.util.List;

@Reflectable(name="reflectable",  value = "какие-то метаданные")
public class User extends Entity {

    public Integer id;
    @Reflectable2(name="reflectable2",  value = "какие-то метаданные2")
    public String name;
    public int age;
    @Has(childFieldName = "userId", parentFieldName = "id")
    public List<Auto> autos;
}