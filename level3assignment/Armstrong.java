
import java.util.Scanner;

public class Armstrong {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a number:");
        int num=sc.nextInt();
        int temp=num;
        int sum=0;

        while(temp!=0){
            int digit=temp%10;
            sum+=Math.pow(digit,3);
            temp/=10;
        }

        if(sum==num){
            System.out.println("Number is Armstrong");
        }else{
            System.out.println("Number is not Armstrong");
        }
    }
}

