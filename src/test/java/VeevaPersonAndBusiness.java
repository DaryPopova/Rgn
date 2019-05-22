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
import java.util.Collection;

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

        linkTables(businessAccounts, personAccounts);
        for (Entity businessAccount: businessAccounts) {
            log(businessAccount);
        }
    }

    public void linkTables(ArrayList<BusinessAccount> businessAccounts, ArrayList<PersonAccount> personAccounts) {
        for (Entity entity: businessAccounts) {
            ArrayList<PersonAccount> listOfPersonAccounts = new ArrayList<>();
            linkListWithOneEntity(entity, personAccounts, listOfPersonAccounts);
        }
    }

    public void linkListWithOneEntity(Entity entity, ArrayList<PersonAccount> personAccounts, Collection listOfPersonAccounts) {
        for (Field field : entity.getClass().getDeclaredFields()) {
            if (field.getDeclaredAnnotation(Has.class) != null &&
                    field.getDeclaredAnnotation(Has.class).childClass().equals(PersonAccount.class)) {
              addToList(entity, field, personAccounts, listOfPersonAccounts);
            }
        }
    }

      public void addToList(Entity entity, Field field, ArrayList<PersonAccount> personAccounts, Collection listOfPersonAccounts) {
          if (ObjectTools.getTypeKind(field).equals(FieldTypeKind.COLLECTION)) {
              try {
                  field.set(entity, listOfPersonAccounts);
              } catch (IllegalAccessException e) {
                  System.out.println("Исключение IllegalAccessException");
              }
              for (PersonAccount personAccount : personAccounts) {
                  for (Field personField : personAccount.getClass().getDeclaredFields()) {
                      if ((personField.getName().equals(field.getAnnotation(Has.class).childFieldName()))) {
                          for (Field entityField : entity.getClass().getDeclaredFields()) {
                              if (entityField.getName().equals(field.getAnnotation(Has.class).parentFieldName()) &&
                                  getObject(personField, personAccount).equals(getObject(entityField, entity))) {
                                      listOfPersonAccounts.add(personAccount);
                                  }
                              }
                          }
                      }
                  }
              }
          }
      }