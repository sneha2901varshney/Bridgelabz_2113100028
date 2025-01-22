import java.util.Scanner;

public class WeightConversion {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the weight in pounds: ");
        double weightInPounds = input.nextDouble();

        double conversionFactor = 2.2;

        double weightInKilograms = weightInPounds / conversionFactor;
        System.out.println("The weight of the person in pound is " + weightInPounds + " and in kg is " + weightInKilograms);
        input.close();
    }
}

