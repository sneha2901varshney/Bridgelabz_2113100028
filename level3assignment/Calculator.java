import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the first number:");
        double num1 = sc.nextDouble();

        System.out.println("Enter the second number:");
        double num2 = sc.nextDouble();

        System.out.println("Enter the operator (+,-,*,/)");
        String op = sc.next();

        switch (op) {
            case "+":
                System.out.println("Addition of two no. is " + (num1 + num2));
                break;
            case "-":
                System.out.println("Subtration of two no. is " +  (num1 - num2));
                break;
            case "*":
                System.out.println("Product of two no. is " + (num1 * num2));
                break;
            case "/":
                System.out.println("Division of two no. is " + (num1 / num2));
                break;
        }
    }

}
