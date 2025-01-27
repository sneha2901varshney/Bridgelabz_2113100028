package Assignment5.Level1;

import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        int num;
        int[] table = new int[10];
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number:");
        num = sc.nextInt();

        for (int i = 0; i < 10; i++) {
            table[i] = (i + 1) * num;
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(num + " * " + (i + 1) + " = " + table[i]);
        }
    }
}
