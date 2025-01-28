import java.util.Scanner;

public class Athlete {

    public static double Perimeter(double side1, double side2, double side3) {
        return (side1 + side2 + side3);
    }

    public static int Rounds(double perimeter, double totalDistance) {
        return (int) Math.ceil(totalDistance / perimeter);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the first side of the triangular park (in meters): ");
        double side1 = sc.nextDouble();
        
        System.out.print("Enter the second side of the triangular park (in meters): ");
        double side2 = sc.nextDouble();
        
        System.out.print("Enter the third side of the triangular park (in meters): ");
        double side3 = sc.nextDouble();

        double perimeter = Perimeter(side1, side2, side3);
        double totalDistance = 5000;

        int rounds = Rounds(perimeter, totalDistance);

        System.out.println("The athlete needs to complete " + rounds + " rounds to cover 5 km.");
    }
}