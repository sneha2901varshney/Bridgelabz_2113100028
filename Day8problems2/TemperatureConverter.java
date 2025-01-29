import java.util.Scanner;

public class TemperatureConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter temperature value: ");
        double temp = scanner.nextDouble();
        
        System.out.print("Enter conversion type (1 for Fahrenheit to Celsius, 2 for Celsius to Fahrenheit): ");
        int choice = scanner.nextInt();
        
        if (choice == 1) {
            double celsius = fahrenheitToCelsius(temp);
            System.out.println(temp + " Fahrenheit is " + celsius + " Celsius.");
        } else if (choice == 2) {
            double fahrenheit = celsiusToFahrenheit(temp);
            System.out.println(temp + " Celsius is " + fahrenheit + " Fahrenheit.");
        } else {
            System.out.println("Invalid choice.");
        }
    }

    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }
}

