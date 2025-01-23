import java.util.Scanner;
public class LeapYear {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a Year: ");
        int Year = sc.nextInt();
        if (Year >= 1582) 
           {
            if (Year % 4 == 0) 
            {
                if (Year % 100 != 0)
                {
                    System.out.println(Year + " is a Leap Year");
                } 
                else if (Year % 400 == 0)
                {
                    System.out.println(Year + " is a Leap Year.");
                } 
                else 
                {
                    System.out.println(Year + " is not a Leap Year.");
                }
            } 
             else 
              {
                System.out.println(Year + " is not a Leap Year.");
            }
        }
           else 
           {
            System.out.println("The year must be greater than or equal to 1582");
           }
 
        sc.close();
    }
}
