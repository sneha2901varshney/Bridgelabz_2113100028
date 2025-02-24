package AssignmentReflections;


import java.lang.reflect.Field;

class Configuration {
    private static String API_KEY = "ORIGINAL_API_KEY";

    public static String getApiKey() {
        return API_KEY;
    }
}

public class ModifyStaticField {
    public static void main(String[] args) throws Exception {

        Class<?> cls = Configuration.class;

        Field field = cls.getDeclaredField("API_KEY");

        field.setAccessible(true);

        field.set(null, "NEW_SECRET_API_KEY");

        System.out.println("Updated API_KEY: " + Configuration.getApiKey());
    }
}



