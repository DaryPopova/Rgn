package models;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collection;

public class FieldsPrinter {
    public static void printParameters(Object object) throws IllegalAccessException {
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            Type fieldType = field.getGenericType();

            if (!(field.getType().equals(Class.class) || Arrays.stream(field.getDeclaredAnnotations()).anyMatch(
                    annotation -> annotation instanceof Nonreflectable))) {
                if (!Collection.class.isAssignableFrom(field.getType())) {
                    System.out.println("Имя: " + field.getName());
                    System.out.println("Тип: " + fieldType);
                    field.setAccessible(true);
                    System.out.println("Значение: " + field.get(object));
                    System.out.println();
                    if (!(field.getType().isPrimitive() || new Primitive().primitiveClasses.contains(field.getType()) ||
                            field.getType().equals(String.class))) {
                        printParameters(field.get(object));
                    }
                } else {
                    System.out.println("Имя: " + field.getName());
                    for (Object o : (Collection) field.get(object)) {
                        System.out.println(o);
                        printParameters(o);
                    }
                }
            }

        }
    }
}
