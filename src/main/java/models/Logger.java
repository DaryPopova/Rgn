package models;

import models.entities.Entity;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collection;

public class Logger {
    public static Report logToReport(Object object, Report report) throws IllegalAccessException {
        report.addLine("%s: %s", "Name of object", object.toString());
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (!(field.getType().equals(Class.class) || Arrays.stream(field.getDeclaredAnnotations()).anyMatch(
                    annotation -> annotation instanceof NonReflectable))) {
                if (!Collection.class.isAssignableFrom(field.getType())) {
                    field.setAccessible(true);
                    report.addLine("%s: %s", field.getName(), field.get(object).toString());
                    if (!(field.getType().isPrimitive() || new Primitive().primitiveClasses.contains(field.getType()) ||
                            field.getType().equals(String.class))) {
                        report.indent();
                        logToReport(field.get(object), report);
                        report.unindent();
                    }
                } else {
                    report.indent();
                    for (Object o : (Collection) field.get(object)) {
                        logToReport(o, report);
                    }
                    report.unindent();
                }
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
