import java.util.Scanner;

public class LeapYear2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a year: ");
        int Year = sc.nextInt();
        
        if (Year >= 1582 && ((Year % 4 == 0 && Year % 100 != 0) || (Year % 400 == 0))) 
        {
            System.out.println(Year + " is a Leap Year.");
        } 
        else if (Year >= 1582) 
        {
            System.out.println(Year + " is not a Leap Year.");
        }
       
        sc.close();
    }
}
