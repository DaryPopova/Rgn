package models;

import models.entities.Entity;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;

public class Logger {
    public static Report logToReport(Object object, Report report){
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
           switch (ObjectTools.getTypeKind(field)) {
               case PRIMITIVE:
               case STRING:
                    field.setAccessible(true);
                    report.addLine("%s: %s", field.getName(), getObject(field, object).toString());
                    break;

               case COMPLEX:
                   field.setAccessible(true);
                   report.addLine("%s: %s %s", field.getName(), "Object of",field.getType().toString());
                   report.indent();
                   logToReport(getObject(field, object), report);
                   report.unindent();
                   break;

               case COLLECTION:
                   field.setAccessible(true);
                   report.addLine("%s: %s %s", field.getName(), "Collection of",
                           (field.getGenericType()).toString());
                   report.indent();
                   for (Object o : (Collection) getObject(field, object)) {
                        logToReport(o, report);
                    }
                    report.unindent();
                    break;
            }
        }
        return report;
    }

    public static Report logToReport(Entity entity) throws IllegalAccessException {
        Report report = new Report();
        logToReport(entity, report);
        report.addLine("%s", "-------------------");
        return report;
    }

    public static void log(Entity entity) throws IllegalAccessException {
        System.out.println(logToReport(entity).toString());
    }

    private static Object getObject(Field field, Object object) {
        try {
            if (field != null) {
                return field.get(object);
            } else return "[null]";
        } catch (IllegalAccessException e) {
            return "Исключение IllegalAccessException";
        }
    }
}