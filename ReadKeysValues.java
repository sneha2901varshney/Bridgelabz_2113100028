package JSON;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class ReadKeysValues {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(new File("D:\\java\\JSON_Assignment\\StudentObject"));
            printKeysAndValues(rootNode, "");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printKeysAndValues(JsonNode node, String parentKey) {
        for (String fieldName : (Iterable<String>) node::fieldNames) {
            JsonNode valueNode = node.get(fieldName);
            String key = parentKey.isEmpty() ? fieldName : parentKey + "." + fieldName;

            if (valueNode.isObject()) {
                printKeysAndValues(valueNode, key);
            } else if (valueNode.isArray()) {
                for (int i = 0; i < valueNode.size(); i++) {
                    printKeysAndValues(valueNode.get(i), key + "[" + i + "]");
                }
            } else {
                System.out.println(key + ": " + valueNode.asText());
            }
        }
    }
}
