package CSV;
import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class CSVReportFromDatabase {
    public static void main(String[] args) {
        String csvFile = "employee_report.csv";
        List<String[]> employees = Arrays.asList(
                new String[]{"Employee ID", "Name", "Department", "Salary"},
                new String[]{"1", "Anika", "HR", "50000"},
                new String[]{"2", "Karan", "IT", "60000"},
                new String[]{"3", "Shikha", "Finance", "55000"}
        );

        try (CSVWriter writer = new CSVWriter(new FileWriter(csvFile))) {
            writer.writeAll(employees);
            System.out.println("CSV report '" + csvFile + "' generated successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}