
import java.util.Scanner;

public class CheckHarshad {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number:");
        int num = sc.nextInt();
        int temp = num;
        int sum = 0;

        while (temp != 0) {
            int digit = temp % 10;
            sum += digit;
            temp /= 10;
        }
        if (num % sum == 0) {
            System.out.println("Number is Harshad");
        } else {
            System.out.println("Number is not Harshad");
        }
    }
}

