package CSV;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class SearchRecord {
    public static void main(String[] args) {
        String filePath = "employee.csv";
        String employeeName = "Priya";
        searchEmployee(filePath, employeeName);
    }

    public static void searchEmployee(String filePath, String name) {
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            List<String[]> records = reader.readAll();
            boolean isHeader = true;

            while (records != null && !records.isEmpty()) {
                for (String[] row : records) {
                    if (isHeader) {
                        isHeader = false; // Skip the header row
                        continue;
                    }

                    // Check if the name matches
                    if (row.length >= 4 && row[1].trim().equalsIgnoreCase(name)) {
                        String department = row[2].trim();
                        String salary = row[3].trim();
                        System.out.println("Employee found: " + name);
                        System.out.println("Department: " + department);
                        System.out.println("Salary: " + salary);
                        return; // Exit after finding the employee
                    }
                }
            }
            System.out.println("Employee not found: " + name); // If no match found
        } catch (IOException | CsvException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
