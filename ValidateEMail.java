package JSON;

import org.everit.json.schema.Schema;
import org.everit.json.schema.SchemaException;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.InputStream;

public class ValidateEMail {
    public static void main(String[] args) {
        String jsonData = "{\"email\": \"example@domain.com\"}";
        validateEmail(jsonData);
    }

    private static void validateEmail(String jsonData) {
        InputStream schemaStream = ValidateEMail.class.getResourceAsStream("D:\\java\\JSON_Assignment\\src\\main\\java\\JSON\\email-schema.json");
        if (schemaStream == null) {
            System.err.println("Schema file not found.");
            return;
        }

        JSONObject jsonSchema = new JSONObject(new JSONTokener(schemaStream));
        JSONObject jsonSubject = new JSONObject(jsonData);

        try {
            Schema schema = SchemaLoader.load(jsonSchema);
            schema.validate(jsonSubject);
            System.out.println("Email is valid.");
        } catch (SchemaException e) {
            System.err.println("Email is invalid: " + e.getMessage());
        }
    }
}
