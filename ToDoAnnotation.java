package AssignmentAnnotations;
import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Todo {
    String task();
    String assignedTo();
    String priority() default "MEDIUM";
}

class Project {

    @Todo(task = "Implement user authentication", assignedTo = "Sneha")
    public void userAuth() {
        System.out.println("User authentication method.");
    }

    @Todo(task = "Create dashboard UI", assignedTo = "Priya", priority = "HIGH")
    public void createDashboard() {
        System.out.println("Dashboard creation method.");
    }

    @Todo(task = "Setup database connections", assignedTo = "Abhi")
    public void setupDatabase() {
        System.out.println("Database setup method.");
    }
}

public class ToDoAnnotation {
    public static void main(String[] args) {
        Method[] methods = Project.class.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(Todo.class)) {
                Todo todo = method.getAnnotation(Todo.class);
                System.out.println("Task: " + todo.task());
                System.out.println("Assigned To: " + todo.assignedTo());
                System.out.println("Priority: " + todo.priority());
                System.out.println("Method: " + method.getName());
                System.out.println();
            }
        }
    }
}
