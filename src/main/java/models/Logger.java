package models;

import models.entities.Entity;

import java.lang.reflect.Field;
import java.util.Collection;

public class Logger {
    public static Report logToReport(Object object, Report report) throws IllegalAccessException {
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
           switch (ObjectTools.getTypeKind(field)) {
               case PRIMITIVE:
               case STRING:
                    field.setAccessible(true);
                    report.addLine("%s: %s", field.getName(), field.get(object).toString());
                    break;

               case COMPLEX:
                   field.setAccessible(true);
                   report.indent();
                   report.addLine("%s: %s %s", field.getName(), "Object of",field.getType().toString());
                   logToReport(field.get(object), report);
                   report.unindent();
                   break;

               case COLLECTION:
                   field.setAccessible(true);
                   report.addLine("%s: %s %s", field.getName(), "Collection of",
                   field.getGenericType().toString().replaceAll(".*<", "").replaceAll(">", ""));
                   report.indent();
                   for (Object o : (Collection) field.get(object)) {
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
}