import java.util.Scanner;

public class StudentGrades {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int numberOfStudents = sc.nextInt();
        
        double[][] marks = new double[numberOfStudents][3];
        double[] percentages = new double[numberOfStudents];
        String[] grades = new String[numberOfStudents];
        String[] remarks = new String[remarksOfStudents];

        
        for (int i = 0; i < numberOfStudents; i++) {
            for (int j = 0; j < 3; j++) {
                double mark;
                do {
                    if (j == 0) System.out.print("Enter marks for Physics for student " + (i + 1) + ": ");
                    if (j == 1) System.out.print("Enter marks for Chemistry for student " + (i + 1) + ": ");
                    if (j == 2) System.out.print("Enter marks for Maths for student " + (i + 1) + ": ");
                    mark = sc.nextDouble();
                    if (mark < 0) System.out.println("Marks cannot be negative. Please enter again.");
                } while (mark < 0);
                marks[i][j] = mark;
            }
            
            double totalMarks = marks[i][0] + marks[i][1] + marks[i][2];
            percentages[i] = (totalMarks / 300) * 100;
            
            if (percentages[i] >= 80) {
                grades[i] = "A";
                remarks[i] = "Level 4,above agency-normalized standards";
            } else if (percentages[i] >= 70 && percentages[i] <=79) {
                grades[i] = "B";
                remarks[i] = "Level 3,at agency-normalized standards";
            } else if (percentages[i] >= 60 && percentages[i] <=69) {
                grades[i] = "C";
                remarks[i] = "Level 2,but approaching agency-normalized standards";
            } else if (percentages[i] >= 70 && percentages[i] <=79) {
                grades[i] = "D";
                remarks[i] = "Level 1,well below agency-normalized standards";
            } else if (percentages[i] >= 70 && percentages[i] <=79) {
                grades[i] = "E";
                remarks[i] = "Level 1-,too below agency-normalized standards";
            } else (percentages[i] >= 70 && percentages[i] <=79) {
                grades[i] = "R";
                remarks[i] = "Remiodal standards";
            }
        }
        
        for (int i = 0; i < numberOfStudents; i++) {
            System.out.println("Student " + (i + 1) + ":");
            System.out.println("Physics: " + marks[i][0]);
            System.out.println("Chemistry: " + marks[i][1]);
            System.out.println("Maths: " + marks[i][2]);
            System.out.println("Percentage: " + percentages[i] + "%");
            System.out.println("Grade: " + grades[i]);
            System.out.println();
        }
    }
}
