package CSV;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class SortCSV {
    public static void main(String[] args) {
        String filePath = "employee.csv";
        printTopEmployees(filePath, 5);
    }

    public static void printTopEmployees(String filePath, int topN) {
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            List<String[]> records = reader.readAll();
            boolean isHeader = true;
            records.remove(0);

            records.sort((a, b) -> {
                int salaryA = Integer.parseInt(a[3].trim());
                int salaryB = Integer.parseInt(b[3].trim());
                return Integer.compare(salaryB, salaryA);
            });

            System.out.println("Top " + topN + " highest-paid employees:");
            for (int i = 0; i < Math.min(topN, records.size()); i++) {
                String[] row = records.get(i);
                System.out.println("ID: " + row[0] + ", Name: " + row[1] + ", Department: " + row[2] + ", Salary: " + row[3]);
            }
        } catch (IOException | CsvException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
