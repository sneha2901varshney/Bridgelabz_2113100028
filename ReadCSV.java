import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.* ;

public class ReadCSV {
    public static void main(String[] args) throws IOException {
        String csvfile = "student.csv";

        FileReader reader = new FileReader(csvfile);
        BufferedReader bfrreader = new BufferedReader(reader);

        String line;
        while ((line = bfrreader.readLine()) != null) {
            String[] data = line.split(",");
            for (String value : data) {
                System.out.print(value + "\t");
            }
        }
    }
}






