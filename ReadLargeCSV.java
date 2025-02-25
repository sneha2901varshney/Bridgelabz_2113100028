package CSV;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadLargeCSV {
    public static void main(String[] args) {
        String filePath = "updated_employees.csv";
        int chunkSize = 100;
        processLargeCSV(filePath, chunkSize);
    }

    public static void processLargeCSV(String filePath, int chunkSize) {
        int totalRecordsProcessed = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            String[] header = br.readLine().split(",");
            int currentChunkCount = 0;

            while ((line = br.readLine()) != null) {
                currentChunkCount++;
                totalRecordsProcessed++;

                if (currentChunkCount == chunkSize) {
                    System.out.println("Processed " + chunkSize + " records.");
                    currentChunkCount = 0;
                }
            }

            if (currentChunkCount > 0) {
                System.out.println("Processed " + currentChunkCount + " records.");
            }

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

        System.out.println("Total records processed: " + totalRecordsProcessed);
    }
}
