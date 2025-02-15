package AssignmentFileReaderInputStreamReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class readFile {
    public static void main(String[] args) {
        String fileName = "example.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
