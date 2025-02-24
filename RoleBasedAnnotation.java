package AssignmentAnnotations;
import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface RoleAllowed {
    String value();
}

class AccessControl {

    @RoleAllowed("ADMIN")
    public void adminOnlyMethod() {
        System.out.println("Access granted to ADMIN: Executing admin-only method.");
    }

    public void executeMethod(String role) {
        Method[] methods = this.getClass().getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(RoleAllowed.class)) {
                RoleAllowed roleAllowed = method.getAnnotation(RoleAllowed.class);
                if (roleAllowed.value().equals(role)) {
                    try {
                        method.invoke(this);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return;
                }
            }
        }
        System.out.println("Access Denied!");
    }
}

public class RoleBasedAnnotation {
    public static void main(String[] args) {
        AccessControl accessControl = new AccessControl();

        String userRoleAdmin = "ADMIN";
        String userRoleUser = "USER";

        System.out.println("Attempting to access with ADMIN role:");
        accessControl.executeMethod(userRoleAdmin);

        System.out.println("Attempting to access with USER role:");
        accessControl.executeMethod(userRoleUser);
    }
}

