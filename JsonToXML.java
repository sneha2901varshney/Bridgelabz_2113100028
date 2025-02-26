package JSON;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class JsonToXML {
    public static void main(String[] args) {
        String jsonString = "{\"name\": \"Sneha\", \"age\": 21, \"email\": \"sneha@gmail.com\"}";

        try {
            ObjectMapper jsonMapper = new ObjectMapper();
            XmlMapper xmlMapper = new XmlMapper();

            Object jsonObject = jsonMapper.readValue(jsonString, Object.class);

            String xmlString = xmlMapper.writeValueAsString(jsonObject);
            System.out.println("XML Output:\n" + xmlString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
