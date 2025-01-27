package Assignment5.Level1;

import java.util.Scanner;

public class StoreValuesandSum {

    public static void main(String[] args) {

        int[] num = new int[10];
        int i=0, sum = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a numbers(upto 10)");

        while (true) {
            int temp = sc.nextInt();
            if (i == 10) {
                break;
            } else if (temp <= 0) {
                break;
            } else {
                num[i++] = temp;
            }
        }

        for (int j = 0; j < 10; j++) {
            sum += num[j];
        }

        System.out.println("Sum of numbers is " + sum);
    }

}
