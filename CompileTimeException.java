package AssignmentExceptionHandling;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CompileTimeException {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("D:\\java\\JavaAssignment\\src\\AssignmentExceptionHandling\\text.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("An IOException occurred: " + e.getMessage());
        }
    }
}


