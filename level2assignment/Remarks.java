import java.util.Scanner;

public class Remarks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter marks for Physics: ");
        double Physics = sc.nextDouble();
        
        System.out.print("Enter marks for Chemistry: ");
        double Chemistry = sc.nextDouble();
        
        System.out.print("Enter marks for Mathematics: ");
        double Maths = sc.nextDouble();
     
        double percentage = ((Physics + Chemistry + Maths) / 300) * 100;
        
        double Average = Physics + Chemistry + Maths / 3;
        
        System.out.println("Average Marks: " + Average);
        
        String grade = "";
        String remarks = "";
        
        if (percentage >= 85) {
            grade = "A";
            remarks = "Level 4, above agency-normalized standards";
        } 
           else if (percentage >= 70 &&  percentage <= 79) 
           {
            grade = "B";
            remarks = "Level 3, at agency-normalized standards";
        }
           else if (percentage >= 60 &&  percentage <= 69)
          {
            grade = "C";
            remarks = "Level 2, below, but approaching agency-normalized standards";
        } else if (percentage >= 50 && percentage <= 59) {
            grade = "D";
            remarks = "Level 1, well below agency-normalized standars";
        } else if (percentage >= 40 && percentage <= 49) {
            grade = "E";
            remarks = "Level 1- , too below agency-normalized standards";
        } else if  (percentage <= 39) {
            grade = "R";
            remarks = "Remedial standards";
        }
        
        System.out.println("Percentage: " + percentage + "%");
        System.out.println("Grade: " + grade);
        System.out.println("Remarks: " + remarks);
        
        sc.close();
    }
}
