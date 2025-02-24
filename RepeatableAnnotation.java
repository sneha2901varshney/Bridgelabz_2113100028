package AssignmentAnnotations;
import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface BugReports {
    BugReport[] value();
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(BugReports.class)
@interface BugReport {
    String description();
}

class Software {

    @BugReport(description = "NullPointerException occurs on edge cases")
    @BugReport(description = "Performance issue when processing large data")
    public void processData() {
        System.out.println("Processing data...");
    }
}

public class RepeatableAnnotation {
    public static void main(String[] args) {
        try {
            Method method = Software.class.getMethod("processData");
            if (method.isAnnotationPresent(BugReports.class)) {
                BugReports bugReports = method.getAnnotation(BugReports.class);
                for (BugReport bug : bugReports.value()) {
                    System.out.println("Bug: " + bug.description());
                }
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
