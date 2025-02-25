package CSV;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MergeCSV {
    public static void main(String[] args) throws IOException {
        String students1Path = "D://java/JavaAssignment/students1.csv";

        FileWriter writer = new FileWriter(students1Path);
        writer.append("ID,Name,Age\n");
        writer.append("104,Sneha Varshney,21\n");
        writer.append("105,Shreya Varshney,17 \n");
        writer.append("106,Tejaswa Varshney,15 \n");
        writer.append("107,Priya,20 \n");
        writer.append("108,Aakash,22 \n");
        writer.append("109,Rohit,25 \n");

        writer.close();

        System.out.println("CSV file written successfully!" +students1Path );


        String students2Path = "D://java/JavaAssignment/students2.csv";
        FileWriter wr = new FileWriter(students2Path);
        wr.append("ID,Marks,Grade\n");
        wr.append("104,99,A \n");
        wr.append("105,89,B \n");
        wr.append("106,95,A \n");
        wr.append("107,70,D \n");
        wr.append("108,78,C \n");
        wr.append("109,83,B \n");

        wr.close();

        System.out.println("CSV file written successfully!" +students2Path );


        String mergedFilePath = "merged_students.csv";
        mergeCSVFiles(students1Path, students2Path, mergedFilePath);
    }





    public static void mergeCSVFiles(String students1Path, String students2Path, String mergedFilePath) {
        Map<String, String[]> studentsMap = new HashMap<>();

        try (CSVReader reader1 = new CSVReader(new FileReader(students1Path))) {
            List<String[]> records1 = reader1.readAll();
            boolean isHeader1 = true;

            for (String[] row : records1) {
                if (isHeader1) {
                    isHeader1 = false;
                    continue;
                }
                String id = row[0].trim();
                studentsMap.put(id, new String[] { row[1], row[2] });
            }
        } catch (IOException | CsvException e) {
            System.err.println("Error reading students1.csv: " + e.getMessage());
            return;
        }

        try (CSVReader reader2 = new CSVReader(new FileReader(students2Path))) {
            List<String[]> records2 = reader2.readAll();
            boolean isHeader2 = true;

            try (CSVWriter writer = new CSVWriter(new FileWriter(mergedFilePath))) {
                String[] header = {"ID", "Name", "Age", "Marks", "Grade"};
                writer.writeNext(header);

                for (String[] row : records2) {
                    if (isHeader2) {
                        isHeader2 = false;
                        continue;
                    }
                    String id = row[0].trim();
                    if (studentsMap.containsKey(id)) {
                        String[] studentDetails = studentsMap.get(id);
                        String[] mergedRow = {id, studentDetails[0], studentDetails[1], row[1], row[2]};
                        writer.writeNext(mergedRow);
                    }
                }
            }
        } catch (IOException | CsvException e) {
            System.err.println("Error reading students2.csv: " + e.getMessage());
        }
    }
}
