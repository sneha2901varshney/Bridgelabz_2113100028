
import java.util.Scanner;

public class DigitCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number");
        int num = sc.nextInt();

        int count=(int)Math.log10(num)+1;
        System.out.println("Number of digits in "+ num + " is " + count);
    }
}

