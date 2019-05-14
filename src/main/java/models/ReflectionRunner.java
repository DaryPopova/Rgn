package models;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.*;

public class ReflectionRunner {
    public static void main(String[] args) throws Exception {
        User user = new User();
        user.id = 1;
        user.name = "Ddff";
        user.age = 24;
        user.fullName = new FullName();
        user.fullName.longName = "Qqqq";
        user.fullName.secondName = "Wwww";
        user.fullName.surname = "Eeee";
        Auto ferrari = new Auto();
        ferrari.id = 3;
        ferrari.model = "Ferrari";
        ferrari.color = "red";
        user.addAuto(ferrari);
        Auto ford = new Auto();
        ford.id = 2;
        ford.model = "Ford";
        ford.color = "black";
        user.addAuto(ford);
        Integer integer = 23;
        int integ = 45;
        printParameters(user);
        Class userClass = User.class;
        Annotation[] annotations = userClass.getAnnotations();

        for (Annotation annotation : annotations) {
            if (annotation instanceof Reflectable) {
                Reflectable mAnnotation = (Reflectable) annotation;
                System.out.println("name: " + mAnnotation.name());
                System.out.println("value: " + mAnnotation.value());
            }
        }

        Method method = userClass.getMethod("addAuto", Auto.class);

        Annotation[] annotations1 = method.getDeclaredAnnotations();

        for (Annotation annotation : annotations1) {
            if (annotation instanceof Reflectable1) {
                Reflectable1 mAnnotation = (Reflectable1) annotation;
                System.out.println("name: " + mAnnotation.name());
                System.out.println("value: " + mAnnotation.value());
            }
        }

        Field field = userClass.getField("name");

        Annotation[] annotations2 = field.getDeclaredAnnotations();

        for (Annotation annotation : annotations2) {
            if (annotation instanceof Reflectable2) {
                Reflectable2 mAnnotation = (Reflectable2) annotation;
                System.out.println("name: " + mAnnotation.name());
                System.out.println("value: " + mAnnotation.value());
            }
        }
    }

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
