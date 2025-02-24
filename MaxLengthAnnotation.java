package AssignmentAnnotations;
import java.lang.annotation.*;
import java.lang.reflect.Field;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MaxLength {
    int value();
}

class User {
    @MaxLength(10)
    private String username;

    public User(String username) {
        validateUsername(username);
        this.username = username;
    }

    private void validateUsername(String username) {
        Field[] fields = this.getClass().getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(MaxLength.class)) {
                MaxLength maxLength = field.getAnnotation(MaxLength.class);
                if (username.length() > maxLength.value()) {
                    throw new IllegalArgumentException("Username cannot exceed " + maxLength.value() + " characters.");
                }
            }
        }
    }

    public String getUsername() {
        return username;
    }
}

public class MaxLengthAnnotation {
    public static void main(String[] args) {
        try {
            User user1 = new User("Sneha");
            System.out.println("Username: " + user1.getUsername());

            User user2 = new User("ThisUsernameIsTooLong");
            System.out.println("Username: " + user2.getUsername());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
