package AssignmentAnnotations;
import java.lang.annotation.*;
import java.lang.reflect.Field;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface JsonField {
    String name();
}

class User2{
    @JsonField(name = "user_name")
    private String username;
    @JsonField(name = "user_age")
    private int age;

    public User2(String username, int age) {
        this.username = username;
        this.age = age;
    }
}

class JsonSerializer {
    public static String serialize(Object object) {
        StringBuilder jsonBuilder = new StringBuilder("{");
        Field[] fields = object.getClass().getDeclaredFields();

        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            if (field.isAnnotationPresent(JsonField.class)) {
                JsonField jsonField = field.getAnnotation(JsonField.class);
                field.setAccessible(true);
                try {
                    String jsonKey = jsonField.name();
                    Object value = field.get(object);
                    jsonBuilder.append("\"").append(jsonKey).append("\": ");
                    if (value instanceof String) {
                        jsonBuilder.append("\"").append(value).append("\"");
                    } else {
                        jsonBuilder.append(value);
                    }
                    if (i < fields.length - 1) {
                        jsonBuilder.append(", ");
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        jsonBuilder.append("}");
        return jsonBuilder.toString();
    }
}

public class SerializationAnnotation {
    public static void main(String[] args) {
        User2 user = new User2("Sneha",21 );
        String jsonString = JsonSerializer.serialize(user);
        System.out.println("JSON Output: " + jsonString);
    }
}

