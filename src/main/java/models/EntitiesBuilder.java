package models;

import models.entities.Entity;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static models.ObjectTools.getObject;
import static models.ObjectTools.toTypeWithValue;


public class EntitiesBuilder {

    public void buildEntities(ArrayList parentEntities, ArrayList childEntities) throws Exception {
        for (Object parentEntity: parentEntities) {
            ArrayList<Entity> listOfChildEntities = new ArrayList<>();
            buildListWithOneEntity(parentEntity, childEntities, listOfChildEntities);
            for (Object childEntity: listOfChildEntities) {
                initializeParentOwnerOfEntity(childEntity, parentEntity);
            }
        }
    }

    private void initializeParentOwnerOfEntity(Object childEntity, Object parentEntity) throws Exception {
        for (Field field: childEntity.getClass().getFields()) {
            if (field.getAnnotation(ParentOwner.class) != null) {
                field.set(childEntity, parentEntity);
            }
        }
    }

    private void buildListWithOneEntity(Object parentEntity, ArrayList childEntities, ArrayList<Entity> listOfChildEntities) throws NoSuchFieldException {
        for (Field parentLinkedField : parentEntity.getClass().getDeclaredFields()) {
                addToList(parentEntity, parentLinkedField, childEntities, listOfChildEntities);
        }
    }

    private void addToList(Object parentEntity, Field parentLinkedField, ArrayList childEntities, ArrayList listOfChildEntities) {
        if (ObjectTools.getTypeKind(parentLinkedField).equals(FieldTypeKind.COLLECTION)) {
            try {
                parentLinkedField.set(parentEntity, listOfChildEntities);
            } catch (IllegalAccessException e) {
                System.out.println("Исключение IllegalAccessException");
            }
            for (Object childEntity : childEntities) {
                addToListOneChildEntity(parentEntity, childEntity, listOfChildEntities);
            }
        }
    }

    private void addToListOneChildEntity(Object parentEntity, Object childEntity, ArrayList listOfChildEntities) {
        String[] pairsOfParentAndChildFields = {};
        for (Field parentField: parentEntity.getClass().getDeclaredFields()) {
            if (parentField.getAnnotation(Has.class) != null) {
                pairsOfParentAndChildFields = parentField.getAnnotation(Has.class).pairsOfParentAndChildFields();
            }
        }
        List<List<Field>> parentAndChildFieldsArray = getParentAndChildFieldsList(pairsOfParentAndChildFields, parentEntity, childEntity);
        if (allLinkedFieldValuesEqualsEachOther(parentAndChildFieldsArray, parentEntity, childEntity)) {
            listOfChildEntities.add(childEntity);

        }
    }

    private List<List<Field>> getParentAndChildFieldsList(String[] pairsOfParentAndChildFields, Object parentEntity, Object childEntity) {
        List<List<Field>> parentAndChildFieldsArray = new ArrayList<>();
        for (String parentAndChildField: pairsOfParentAndChildFields) {
            String parentFieldName = parentAndChildField.split("\\|")[0];
            String childFieldName = parentAndChildField.split("\\|")[1];
            for (Field childField : childEntity.getClass().getDeclaredFields()) {
                for (Field parentField: parentEntity.getClass().getDeclaredFields())
                if (parentField.getName().equals(parentFieldName) && childField.getName().equals(childFieldName)) {
                    List<Field> parentAndChildFieldPair = new ArrayList<>();
                    parentAndChildFieldPair.add(parentField);
                    parentAndChildFieldPair.add(childField);
                    parentAndChildFieldsArray.add(parentAndChildFieldPair);
                }
            }
        }
        return parentAndChildFieldsArray;
    }

    private boolean allLinkedFieldValuesEqualsEachOther(List<List<Field>> parentAndChildFieldsArray, Object parentEntity, Object childEntity) {
        boolean allLinkedFieldValuesEqualsEachOther = true;
        for (List<Field> parentAndChildFields: parentAndChildFieldsArray) {
            allLinkedFieldValuesEqualsEachOther = allLinkedFieldValuesEqualsEachOther && getObject(parentAndChildFields.get(1), childEntity).equals(getObject(parentAndChildFields.get(0), parentEntity));
        }
        return allLinkedFieldValuesEqualsEachOther;
    }
}