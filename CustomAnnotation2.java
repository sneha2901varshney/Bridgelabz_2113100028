package AssignmentAnnotations;

import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface ImportantMethod {
    String level() default "HIGH";
}

class TaskProcessor {

    @ImportantMethod(level = "LOW")
    public void lowPriorityTask() {
        System.out.println("Low priority task processing.");
    }

    @ImportantMethod
    public void highPriorityTask() {
        System.out.println("High priority task processing.");
    }
}

public class CustomAnnotation2 {
    public static void main(String[] args) {
        Method[] methods = TaskProcessor.class.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(ImportantMethod.class)) {
                ImportantMethod importantMethod = method.getAnnotation(ImportantMethod.class);
                System.out.println("Method: " + method.getName() + ", Importance Level: " + importantMethod.level());
            }
        }
    }
}
