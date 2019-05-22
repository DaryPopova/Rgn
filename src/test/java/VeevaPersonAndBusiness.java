import csv.CsvHandler;
import models.FieldTypeKind;
import models.Has;
import models.ObjectTools;
import models.entities.Entity;
import models.entities.veeva.BusinessAccount;
import models.entities.veeva.PersonAccount;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;

import static models.Logger.getObject;
import static models.Logger.log;

public class VeevaPersonAndBusiness {
    @Test
    public void run() throws Exception {
        CsvHandler csvHandler = new CsvHandler();
        ArrayList<BusinessAccount> businessAccounts = csvHandler.readCsvToListOfEntities(BusinessAccount.class,
                "C:\\Users\\padre\\Downloads\\Microsoft.SkypeApp_kzf8qxf38zg5c!App\\All\\минимальный набор из реальных данных\\businessaccount.csv");
        ArrayList<PersonAccount> personAccounts = csvHandler.readCsvToListOfEntities(PersonAccount.class,
                "C:\\Users\\padre\\Downloads\\Microsoft.SkypeApp_kzf8qxf38zg5c!App\\All\\минимальный набор из реальных данных\\personaccount.csv");

        linkEntities(businessAccounts, personAccounts);
        for (Entity businessAccount: businessAccounts) {
            log(businessAccount);
        }
    }

    public void linkEntities(ArrayList<BusinessAccount> businessAccounts, ArrayList<PersonAccount> personAccounts) {
        for (Entity parentEntity: businessAccounts) {
            ArrayList<PersonAccount> listOfChildEntities = new ArrayList<>();
            linkListWithOneEntity(parentEntity, personAccounts, listOfChildEntities);
        }
    }

    private void linkListWithOneEntity(Entity parentEntity, ArrayList<PersonAccount> personAccounts, ArrayList listOfChildEntities) {
        for (Field parentLinkedField : parentEntity.getClass().getDeclaredFields()) {
            if (parentLinkedField.getDeclaredAnnotation(Has.class) != null &&
                    parentLinkedField.getDeclaredAnnotation(Has.class).childClass().equals(PersonAccount.class)) {
              addToList(parentEntity, parentLinkedField, personAccounts, listOfChildEntities);
            }
        }
    }

    private void addToList(Entity parentEntity, Field parentLinkedField, ArrayList<PersonAccount> personAccounts, ArrayList listOfChildEntities) {
          if (ObjectTools.getTypeKind(parentLinkedField).equals(FieldTypeKind.COLLECTION)) {
              try {
                  parentLinkedField.set(parentEntity, listOfChildEntities);
              } catch (IllegalAccessException e) {
                  System.out.println("Исключение IllegalAccessException");
              }
              for (PersonAccount personAccount : personAccounts) {
                  addToListOneChildEntity(parentEntity, parentLinkedField, personAccount, listOfChildEntities);
                  }
              }
          }

          private void addToListOneChildEntity(Entity parentEntity, Field parentLinkedField, PersonAccount personAccount, ArrayList listOfChildEntities) {
              for (Field childField : personAccount.getClass().getDeclaredFields()) {
                  if ((childField.getName().equals(parentLinkedField.getAnnotation(Has.class).childFieldName()))) {
                      for (Field parentField : parentEntity.getClass().getDeclaredFields()) {
                          if (parentField.getName().equals(parentLinkedField.getAnnotation(Has.class).parentFieldName()) &&
                                  getObject(childField, personAccount).equals(getObject(parentField, parentEntity))) {
                              listOfChildEntities.add(personAccount);
                          }
                      }
                  }
              }
          }


      }