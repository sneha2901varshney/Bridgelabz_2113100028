package AssignmentFileReaderInputStreamReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.IOException;

public class readAndWrite {
    public static void main(String[] args) {
        String fileName = "output.txt";

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             FileWriter fw = new FileWriter(fileName, true)) {

            String input;
            System.out.println("Enter text to write to the file (type 'exit' to stop):");

            while (!(input = br.readLine()).equalsIgnoreCase("exit")) {
                fw.write(input + System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

