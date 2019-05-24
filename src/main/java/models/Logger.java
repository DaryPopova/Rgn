package models;

import java.lang.reflect.Field;
import java.util.Collection;

import static models.ObjectTools.getObject;

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
                   if (getObject(field, object) != null) {
                       for (Object o : (Collection) getObject(field, object)) {
                           logToReport(o, report);
                       }
                   } else {}
                    report.unindent();
                    break;
            }
        }
        return report;
    }

    public static Report logToReport(Object entity) throws IllegalAccessException {
        Report report = new Report();
        logToReport(entity, report);
        report.addLine("%s", "-------------------");
        return report;
    }

    public static void log(Object entity) throws IllegalAccessException {
        System.out.println(logToReport(entity).toString());
    }
}