import models.*;
import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class AnnotationsRunner {

    @Test
    public void runAnnotations() throws NoSuchMethodException, NoSuchFieldException{
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
}