package CSV;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import java.io.*;
import java.util.*;

public class JSONtoCSV {
    public static void main(String[] args) {
        String jsonFile = "student.json";
        String csvFile = "student.csv";
        String outputJsonFile = "students_output.json";

        convertJsonToCsv(jsonFile, csvFile);
        convertCsvToJson(csvFile, outputJsonFile);
    }

    public static void convertJsonToCsv(String jsonFile, String csvFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(jsonFile));
             CSVWriter writer = new CSVWriter(new FileWriter(csvFile))) {

            List<String[]> data = new ArrayList<>();
            String line = reader.readLine();
            if (line == null) return;

            line = line.replace("[", "").replace("]", "").trim();
            String[] headers = line.substring(1, line.indexOf("}"))
                    .replace("\"", "")
                    .split(",");

            data.add(headers);

            while ((line = reader.readLine()) != null) {
                line = line.replace("{", "").replace("}", "").trim();
                String[] values = line.replace("\"", "")
                        .split(",");
                for (int i = 0; i < values.length; i++) {
                    values[i] = values[i].substring(values[i].indexOf(":") + 1).trim();
                }
                data.add(values);
            }

            writer.writeAll(data);
            System.out.println("CSV file '" + csvFile + "' generated successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void convertCsvToJson(String csvFile, String jsonFile) {
        try (CSVReader reader = new CSVReader(new FileReader(csvFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(jsonFile))) {

            List<String[]> data = reader.readAll();
            if (data.isEmpty()) return;

            String[] headers = data.get(0);
            writer.write("[");

            for (int i = 1; i < data.size(); i++) {
                String[] row = data.get(i);
                writer.write("{ ");
                for (int j = 0; j < headers.length; j++) {
                    writer.write("\"" + headers[j] + "\": \"" + row[j] + "\"");
                    if (j < headers.length - 1) {
                        writer.write(", ");
                    }
                }
                writer.write(" }");
                if (i < data.size() - 1) {
                    writer.write(",");
                }
                writer.newLine();
            }

            writer.write("]");
            System.out.println("JSON file '" + jsonFile + "' generated successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}