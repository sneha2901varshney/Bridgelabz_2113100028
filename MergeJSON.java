package JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class MergeJSON {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            String json1 = "{ \"name\": \"Sneha\", \"email\": \"sneha@gmail.com\" }";
            ObjectNode node1 = (ObjectNode) objectMapper.readTree(json1);

            String json2 = "{ \"age\": 21, \"city\": \"Mathura\" }";
            ObjectNode node2 = (ObjectNode) objectMapper.readTree(json2);

            node1.putAll(node2);

            String mergedJson = objectMapper.writeValueAsString(node1);
            System.out.println(mergedJson);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
