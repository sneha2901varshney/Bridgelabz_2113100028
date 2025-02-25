import java.io.IOException;
import java.io.* ;


public class WritingStudent {
    public static void main(String[] args) throws IOException {
        String CsvFileName = "student.csv";

        FileWriter writer = new FileWriter(CsvFileName);
        writer.append("ID,Name,Age,Marks \n");
        writer.append("104,Sneha Varshney,21,92 \n");
        writer.append("105,Shreya Varshney,17,88 \n");
        writer.append("106,Tejaswa Varshney,15,100 \n");
        writer.append("107,Priya,20,78 \n");
        writer.append("108,Aakash,22,88 \n");
        writer.append("109,Rohit,25,85 \n");

        writer.close();

        System.out.println("CSV file written successfully!" +CsvFileName );


    }
}
