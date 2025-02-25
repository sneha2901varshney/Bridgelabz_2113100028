package CSV;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import java.io.*;
import java.util.*;

public class EncryptDecryptCSVData {
    public static void main(String[] args) {
        String csvFile = "student.csv";
        String encryptedCsvFile = "students_encrypted.csv";
        String decryptedCsvFile = "students_decrypted.csv";

        encryptCsv(csvFile, encryptedCsvFile);
        decryptCsv(encryptedCsvFile, decryptedCsvFile);
    }

    public static void encryptCsv(String inputCsv, String outputCsv) {
        try (CSVReader reader = new CSVReader(new FileReader(inputCsv));
             CSVWriter writer = new CSVWriter(new FileWriter(outputCsv))) {

            List<String[]> data = reader.readAll();
            if (data.isEmpty()) return;

            String[] headers = data.get(0);
            writer.writeNext(headers);

            for (int i = 1; i < data.size(); i++) {
                String[] row = data.get(i);
                for (int j = 0; j < row.length; j++) {
                    if (headers[j].equalsIgnoreCase("Salary") || headers[j].equalsIgnoreCase("Email")) {
                        row[j] = new StringBuilder(row[j]).reverse().toString(); // Simple encryption (reversing string)
                    }
                }
                writer.writeNext(row);
            }
            System.out.println("Encrypted CSV file saved as " + outputCsv);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void decryptCsv(String inputCsv, String outputCsv) {
        try (CSVReader reader = new CSVReader(new FileReader(inputCsv));
             CSVWriter writer = new CSVWriter(new FileWriter(outputCsv))) {

            List<String[]> data = reader.readAll();
            if (data.isEmpty()) return;

            String[] headers = data.get(0);
            writer.writeNext(headers);

            for (int i = 1; i < data.size(); i++) {
                String[] row = data.get(i);
                for (int j = 0; j < row.length; j++) {
                    if (headers[j].equalsIgnoreCase("Salary") || headers[j].equalsIgnoreCase("Email")) {
                        row[j] = new StringBuilder(row[j]).reverse().toString(); // Simple decryption (reversing back)
                    }
                }
                writer.writeNext(row);
            }
            System.out.println("Decrypted CSV file saved as " + outputCsv);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
