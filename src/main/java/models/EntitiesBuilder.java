package models;

import models.entities.Entity;

import java.lang.reflect.Field;
import java.util.ArrayList;

import static models.ObjectTools.getObject;


public class EntitiesBuilder {

    public void buildEntities(ArrayList parentEntities, ArrayList childEntities) throws NoSuchFieldException {
        for (Object parentEntity: parentEntities) {
            ArrayList<Entity> listOfChildEntities = new ArrayList<>();
            buildListWithOneEntity(parentEntity, childEntities, listOfChildEntities);
        }
    }

    private void buildListWithOneEntity(Object parentEntity, ArrayList childEntities, ArrayList<Entity> listOfChildEntities) throws NoSuchFieldException {
        for (Field parentLinkedField : parentEntity.getClass().getDeclaredFields()) {
                addToList(parentEntity, parentLinkedField, childEntities, listOfChildEntities);
        }
    }

    private void addToList(Object parentEntity, Field parentLinkedField, ArrayList<Entity> childEntities, ArrayList listOfChildEntities) {
        if (ObjectTools.getTypeKind(parentLinkedField).equals(FieldTypeKind.COLLECTION)) {
            try {
                parentLinkedField.set(parentEntity, listOfChildEntities);
            } catch (IllegalAccessException e) {
                System.out.println("Исключение IllegalAccessException");
            }
            for (Entity childEntity : childEntities) {
                addToListOneChildEntity(parentEntity, parentLinkedField, childEntity, listOfChildEntities);
            }
        }
    }

    private void addToListOneChildEntity(Object parentEntity, Field parentLinkedField, Entity childEntity, ArrayList listOfChildEntities) {
        for (Field childField : childEntity.getClass().getDeclaredFields()) {
            if ((childField.getName().equals(parentLinkedField.getAnnotation(Has.class).childFieldName()))) {
                for (Field parentField : parentEntity.getClass().getDeclaredFields()) {
                    if (parentField.getName().equals(parentLinkedField.getAnnotation(Has.class).parentFieldName()) &&
                            getObject(childField, childEntity).equals(getObject(parentField, parentEntity))) {
                        listOfChildEntities.add(childEntity);
                    }
                }
            }
        }
    }

}
