package AssignmentFileReaderInputStreamReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class compareAll {
    public static void main(String[] args) {
        // Task 1: StringBuilder and StringBuffer Performance Test
        int numConcats = 1000000;
        String str = "hello";

        // StringBuilder test
        long startTime = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numConcats; i++) {
            sb.append(str);
        }
        long endTime = System.nanoTime();
        long sbTime = endTime - startTime;
        System.out.println("StringBuilder time: " + sbTime + " nanoseconds");

        // StringBuffer test
        startTime = System.nanoTime();
        StringBuffer sf = new StringBuffer();
        for (int i = 0; i < numConcats; i++) {
            sf.append(str);
        }
        endTime = System.nanoTime();
        long sfTime = endTime - startTime;
        System.out.println("StringBuffer time: " + sfTime + " nanoseconds");

        // Task 2: FileReader and InputStreamReader to count words in a large file
        String fileName = "largefile.txt"; // Replace with the path to a large file
        long wordCount = 0;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileReader(fileName)))) {
            String line;
            startTime = System.nanoTime();
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                wordCount += words.length;
            }
            endTime = System.nanoTime();
            long fileReadTime = endTime - startTime;
            System.out.println("Word count: " + wordCount);
            System.out.println("File read time: " + fileReadTime + " nanoseconds");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
