package AssignmentRuntimeAnalysis;
import java.io.*;
public class largeFileReadingEfficiency {

    public static void main(String[] args) throws IOException {
        String filePath = "\"C:\\Users\\sneha\\Desktop\\largefile.txt.txt\"";

        long startTime = System.currentTimeMillis();
        testFileReader(filePath);
        long endTime = System.currentTimeMillis();
        System.out.println("FileReader time: " + (endTime - startTime) + "ms");

        startTime = System.currentTimeMillis();
        testInputStreamReader(filePath);
        endTime = System.currentTimeMillis();
        System.out.println("InputStreamReader time: " + (endTime - startTime) + "ms");
    }

    public static void testFileReader(String filePath) throws IOException {
        FileReader fileReader = new FileReader(filePath);
        int character;
        while ((character = fileReader.read()) != -1) {
        }
        fileReader.close();
    }

    public static void testInputStreamReader(String filePath) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(filePath));
        int character;
        while ((character = inputStreamReader.read()) != -1) {
        }
        inputStreamReader.close();
    }
}

