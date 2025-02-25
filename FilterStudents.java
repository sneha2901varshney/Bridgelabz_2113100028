import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class FilterStudents {
    public static void main(String[] args) {
        String filePath = "student.csv";
        int threshold = 80;
        filterHighScorers(filePath, threshold);
    }

    public static void filterHighScorers(String filePath, int threshold) {
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            List<String[]> records = reader.readAll();
            boolean isHeader = true;

            System.out.println("Students who scored more than " + threshold + " marks:");

            for (String[] row : records) {
                if (isHeader) {
                    isHeader = false;
                    continue;
                }

                if (row.length >= 3) {
                    try {
                        String id = row[0].trim();
                        String name = row[1].trim();
                        int marks = Integer.parseInt(row[2].trim());

                        if (marks > threshold) {
                            System.out.println(id + " - " + name + " - " + marks);
                        }
                    } catch (NumberFormatException e) {
                        System.err.println("Invalid number format in row: " + String.join(",", row));
                    }
                } else {
                    System.err.println("Invalid data format in row: " + String.join(",", row));
                }
            }
        } catch (IOException | CsvException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
