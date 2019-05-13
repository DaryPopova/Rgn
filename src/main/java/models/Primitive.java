package models;

import java.util.ArrayList;

public class Primitive {
    public static ArrayList<Class> primitiveClasses = new ArrayList<Class>();

    public Primitive() {
        primitiveClasses.add(Byte.class);
        primitiveClasses.add(Integer.class);
        primitiveClasses.add(Short.class);
        primitiveClasses.add(Long.class);
        primitiveClasses.add(Character.class);
        primitiveClasses.add(Float.class);
        primitiveClasses.add(Double.class);
    }
}