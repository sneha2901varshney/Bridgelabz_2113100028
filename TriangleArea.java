import java.util.Scanner;

public class TriangleArea {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the base of the triangle (in cm): ");
        double base = input.nextDouble();

        System.out.print("Enter the height of the triangle (in cm): ");
        double height = input.nextDouble();

        double area = 0.5 * base * height;
        double areaInch = area / 6.4516;
        System.out.println("The area of the triangle in square centimeters is " + area +
                           " and in square inches is " + areaInch);
        input.close();
    }
}

