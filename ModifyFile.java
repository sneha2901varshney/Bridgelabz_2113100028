package CSV;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ModifyFile {
    public static void main(String[] args) {
        String inputFilePath = "employee.csv";
        String outputFilePath = "updated_employees.csv";
        increaseITSalary(inputFilePath, outputFilePath);
    }

    public static void increaseITSalary(String inputFilePath, String outputFilePath) {
        try (CSVReader reader = new CSVReader(new FileReader(inputFilePath));
             CSVWriter writer = new CSVWriter(new FileWriter(outputFilePath))) {

            List<String[]> records = reader.readAll();
            boolean isHeader = true;
            List<String[]> updatedRecords = new ArrayList<>();

            for (String[] row : records) {
                if (isHeader) {
                    updatedRecords.add(row);
                    isHeader = false;
                    continue;
                }

                if (row.length >= 4 && row[2].trim().equalsIgnoreCase("IT")) {
                    int salary = Integer.parseInt(row[3].trim());
                    salary += salary * 0.10;
                    row[3] = String.valueOf(salary);
                }

                updatedRecords.add(row);
            }

            writer.writeAll(updatedRecords);
            System.out.println("Salaries updated and saved to: " + outputFilePath);

        } catch (IOException | CsvException e) {
            System.err.println("Error processing file: " + e.getMessage());
        }
    }
}

