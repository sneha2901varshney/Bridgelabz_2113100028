import java.util.Scanner;

public class GCDAndLCMCalculator {
    public static void main(String[] args) {
        int num1 = getInput("Enter first number: ");
        int num2 = getInput("Enter second number: ");
        
        int gcd = calculateGCD(num1, num2);
        int lcm = calculateLCM(num1, num2, gcd);
        
        displayResult(gcd, lcm);
    }

    public static int getInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(prompt);
        return scanner.nextInt();
    }

    public static int calculateGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static int calculateLCM(int a, int b, int gcd) {
        return (a * b) / gcd;
    }

    public static void displayResult(int gcd, int lcm) {
        System.out.println("The GCD is: " + gcd);
        System.out.println("The LCM is: " + lcm);
    }
}

