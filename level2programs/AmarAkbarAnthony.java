package Assignment5.Level2;

import java.util.Scanner;


public class AmarAkbarAnthony {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] age = new int[3];
        int[] height = new int[3];

        String[] names = {"Amar", "Akbar", "Anthony"};
        for (int i = 0; i < 3; i++) {
            System.out.println("Enter age and height for " + names[i] + ":");
            age[i] = sc.nextInt();
            height[i] = sc.nextInt();
        }

        int youngestIndex = 0, tallestIndex = 0;
        for (int i = 1; i < 3; i++) {
            if (age[i] < age[youngestIndex]) youngestIndex = i;
            if (height[i] > height[tallestIndex]) tallestIndex = i;
        }

        System.out.println("The youngest is " + names[youngestIndex]);
        System.out.println("The tallest is " + names[tallestIndex]);
    }
}
