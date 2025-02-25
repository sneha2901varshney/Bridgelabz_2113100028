package CSV;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Student {
    private int id;
    private String name;
    private int age;
    private int marks;

    public Student(int id, String name, int age, int marks) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", marks=" + marks +
                '}';
    }
}

public class CsvToJavaObject {
    public static void main(String[] args) {
        String filePath = "student.csv";
        List<Student> students = readStudentsFromCsv(filePath);
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public static List<Student> readStudentsFromCsv(String filePath) {
        List<Student> students = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            List<String[]> records = reader.readAll();
            boolean isHeader = true;

            for (String[] row : records) {
                if (isHeader) {
                    isHeader = false;
                    continue;
                }

                int id = Integer.parseInt(row[0].trim());
                String name = row[1].trim();
                int age = Integer.parseInt(row[2].trim());
                int marks = Integer.parseInt(row[3].trim());

                Student student = new Student(id, name, age, marks);
                students.add(student);
            }
        } catch (IOException | CsvException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        return students;
    }
}
