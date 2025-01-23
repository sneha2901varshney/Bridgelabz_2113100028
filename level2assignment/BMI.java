import java.util.Scanner;

public class BMI {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter weight in kilograms: ");
        double weight = sc.nextDouble();

        System.out.print("Enter height in centimeters: ");
        double heightinCm = sc.nextDouble();

        double heightinM = heightinCm / 100;

        double bmi = weight / (heightinM * heightinM);

        System.out.println("\nCalculated BMI: " + bmi);

        String weightStatus;
        if (bmi < 18.5) 
         {
            weightStatus = "Underweight";
        }
         else if (bmi >= 18.5 && bmi < 24.9) 
         {
            weightStatus = "Normal weight";
        }
          else if (bmi >= 25 && bmi < 29.9)
          {
            weightStatus = "Overweight";
        } 
       else 
          {
            weightStatus = "Obesity";
        }

        System.out.println("Weight Status: " + weightStatus);
        sc.close();
    }
}
