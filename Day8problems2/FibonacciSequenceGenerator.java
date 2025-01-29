import java.util.Scanner;

public class FibonacciSequenceGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of terms in the Fibonacci sequence: ");
        int terms = scanner.nextInt();

        generateFibonacci(terms);

        scanner.close();
    }

    public static void generateFibonacci(int terms) {
        int first = 0, second = 1;
        
        System.out.print("Fibonacci Sequence: ");
        
        for (int i = 1; i <= terms; i++) {
            System.out.print(first + " ");
            int next = first + second;
            first = second;
            second = next;
        }
    }
}