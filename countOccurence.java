package AssignmentFileReaderInputStreamReader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class countOccurence {
    public static void main(String[] args) {
        String fileName = "example.txt";
        String targetWord = "hello";
        int wordCount = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    if (word.equalsIgnoreCase(targetWord)) {
                        wordCount++;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("The word '" + targetWord + "' appears " + wordCount + " times in the file.");
    }
}
