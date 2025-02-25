import java.io.FileWriter;
import java.io.IOException;

public class WriteCSV {
    public static void main(String[] args) throws IOException {
        String CsvFileName = "employee.csv";

        FileWriter writer = new FileWriter(CsvFileName);
        writer.append("ID,Name,Department,Salary \n");
        writer.append("104,Sneha Varshney,Engineering,92000 \n");
        writer.append("105,Shreya Varshney,Management,88000 \n");
        writer.append("106,Tejaswa Varshney,Medical,100000 \n");
        writer.append("107,Priya,Sales,88000 \n");
        writer.append("108,Aakash,IT,88000 \n");
        writer.append("109,Rohit,Sales,88000 \n");

        writer.close();

        System.out.println("CSV file written successfully!" +CsvFileName );


    }
}



