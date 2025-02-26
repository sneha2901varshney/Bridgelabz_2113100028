package JSON;

import com.opencsv.CSVReader;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CSVtoJSON {
    public static void main(String[] args) {
        String csvFile = "D:\\java\\JSON_Assignment\\src\\main\\java\\JSON\\data.csv"; // Adjust the path as needed

        try (CSVReader csvReader = new CSVReader(new FileReader(csvFile))) {
            String[] headers = csvReader.readNext(); // Read header line
            List<Map<String, String>> jsonList = new ArrayList<>();
            String[] nextLine;

            while ((nextLine = csvReader.readNext()) != null) {
                Map<String, String> jsonMap = new HashMap<>();
                for (int i = 0; i < headers.length; i++) {
                    jsonMap.put(headers[i], nextLine[i]);
                }
                jsonList.add(jsonMap);
            }

            ObjectMapper objectMapper = new ObjectMapper();
            String jsonOutput = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonList);
            System.out.println("JSON Output:\n" + jsonOutput);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
