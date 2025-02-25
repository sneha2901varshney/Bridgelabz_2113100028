package CSV;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;

public class ValidateCSV {
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@(.+)$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

    public static void main(String[] args) {
        String filePath = "employee.csv";
        validateCSVData(filePath);
    }

    public static void validateCSVData(String filePath) {
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            List<String[]> records = reader.readAll();
            boolean isHeader = true;

            for (String[] row : records) {
                if (isHeader) {
                    isHeader = false;
                    continue;
                }

                String email = row[2].trim();
                String phoneNumber = row[3].trim();
                boolean isValid = true;

                if (!EMAIL_PATTERN.matcher(email).matches()) {
                    System.out.println("Invalid email: " + email + " in row: " + String.join(", ", row));
                    isValid = false;
                }

                if (!phoneNumber.matches("\\d{10}")) {
                    System.out.println("Invalid phone number: " + phoneNumber + " in row: " + String.join(", ", row));
                    isValid = false;
                }

                if (isValid) {
                    System.out.println("Valid row: " + String.join(", ", row));
                }
            }
        } catch (IOException | CsvException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
