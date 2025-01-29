import java.util.Scanner;

public class FactorialUsingRecursion {
    public static void main(String[] args) {
        int number = getInput();
        int result = calculateFactorial(number);
        displayResult(result);
    }

    public static int getInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number to calculate its factorial: ");
        return scanner.nextInt();
    }

    public static int calculateFactorial(int number) {
        if (number == 0 || number == 1) {
            return 1;
        } else {
            return number * calculateFactorial(number - 1);
        }
    }

    public static void displayResult(int result) {
        System.out.println("The factorial is: " + result);
    }
}

