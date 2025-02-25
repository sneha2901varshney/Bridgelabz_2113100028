package CSV;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DuplicateInCSV {
    public static void main(String[] args) {
        String filePath = "D://java/JavaAssignment/student.csv";
        detectDuplicates(filePath);
    }

    public static void detectDuplicates(String filePath) {
        Map<String, Integer> idCountMap = new HashMap<>();
        Map<String, String[]> duplicateRecords = new HashMap<>();

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            List<String[]> records = reader.readAll();
            boolean isHeader = true;

            for (String[] row : records) {
                if (isHeader) {
                    isHeader = false;
                    continue;
                }
                String id = row[0].trim();
                idCountMap.put(id, idCountMap.getOrDefault(id, 0) + 1);

                if (idCountMap.get(id) > 1) {
                    duplicateRecords.put(id, row);
                }
            }

            if (duplicateRecords.isEmpty()) {
                System.out.println("No duplicate records found.");
            } else {
                System.out.println("Duplicate records:");
                for (String id : duplicateRecords.keySet()) {
                    String[] record = duplicateRecords.get(id);
                    System.out.println(String.join(", ", record));
                }
            }
        } catch (IOException | CsvException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
