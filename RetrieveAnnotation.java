package AssignmentReflections;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface Author {
    String name();
}

@Author(name = "Gulshan")
class Book {
    @Author(name = "Premchand")
    public void display() {
        System.out.println("Displaying Book Details...");
    }
}

public class RetrieveAnnotation {
    public static void main(String[] args) {
        try {
            // Step 3: Get Class object
            Class<?> cls = Book.class;

            // Step 4: Retrieve annotation from class
            if (cls.isAnnotationPresent(Author.class)) {
                Author author = cls.getAnnotation(Author.class);
                System.out.println("Class Author: " + author.name());
            }

            // Step 5: Retrieve annotation from method
            Method method = cls.getMethod("display");
            if (method.isAnnotationPresent(Author.class)) {
                Author authorMethod = method.getAnnotation(Author.class);
                System.out.println("Method Author: " + authorMethod.name());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



