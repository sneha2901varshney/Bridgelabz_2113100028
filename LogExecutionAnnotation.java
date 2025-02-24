package AssignmentAnnotations;
import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface LogExecutionTime {
}

class ExecutionTimer {

    @LogExecutionTime
    public void methodOne() {
        try {
            Thread.sleep(500); // Simulating a delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @LogExecutionTime
    public void methodTwo() {
        try {
            Thread.sleep(300); // Simulating a shorter delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void executeMethods() {
        Method[] methods = this.getClass().getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(LogExecutionTime.class)) {
                long startTime = System.nanoTime();
                try {
                    method.invoke(this);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                long endTime = System.nanoTime();
                long duration = endTime - startTime;
                System.out.println("Execution time of " + method.getName() + ": " + duration + " nanoseconds");
            }
        }
    }
}

public class LogExecutionAnnotation {
    public static void main(String[] args) {
        ExecutionTimer timer = new ExecutionTimer();
        timer.executeMethods();
    }
}
