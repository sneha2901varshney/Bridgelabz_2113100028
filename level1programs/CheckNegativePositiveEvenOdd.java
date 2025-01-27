package Assignment5.Level1;

import java.util.Scanner;

public class CheckNegativePositiveEvenOdd {
    public static void main(String[] args) {
        int[] num = new int[5];
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 5 numbers.");

        for (int i = 0; i < 5; i++) {
            num[i] = sc.nextInt();
        }

        for (int i = 0; i < 5; i++) {
            if(num[i]<0){
                System.out.println(num[i] + " is negative");
            }else if(num[i]>0){
                System.out.print(num[i] + " is positive and ");
                if(num[i]%2==0){
                    System.out.println("even.");
                }else {
                    System.out.println("odd.");
                }
            }else if(num[i]==0){
                System.out.println(num[i] + " is zero.");
            }
        }
        int len=num.length-1;
        if(num[0]<num[len]){
            System.out.println("Firse index element is smaller than last index element");
        }else if(num[0]>num[len]){
            System.out.println("Firse index element is greater than last index element");
        }else if(num[0]==num[len]){
            System.out.println("Firse index element is equal to  last index element");
        }
    }
}
