import java.util.Scanner;

public class YoungestFriend {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter age of Amar: ");
        int AmarAge = sc.nextInt();
        System.out.print("Enter height of Amar (in cm): ");
        int AmarHeight = sc.nextInt();

        System.out.print("Enter age of Akbar: ");
        int AkbarAge = sc.nextInt();
        System.out.print("Enter height of Akbar (in cm): ");
        int AkbarHeight = sc.nextInt();

        System.out.print("Enter age of Anthony: ");
        int AnthonyAge = sc.nextInt();
        System.out.print("Enter height of Anthony (in cm): ");
        int AnthonyHeight = sc.nextInt();

        int YoungestAge = AmarAge;
        String YoungestFriend = "Amar";
        
        if (AkbarAge < YoungestAge) {
            YoungestAge = AkbarAge;
            YoungestFriend = "Akbar";
        }
        if (AnthonyAge < YoungestAge) {
            YoungestAge = AnthonyAge;
            YoungestFriend = "Anthony";
        }

        int tallestHeight = AmarHeight;
        String tallestFriend = "Amar";
        
        if (AkbarHeight > tallestHeight) {
            tallestHeight = AkbarHeight;
            tallestFriend = "Akbar";
        }
        if (AnthonyHeight > tallestHeight) {
            tallestHeight = AnthonyHeight;
            tallestFriend = "Anthony";
        }

        System.out.println("\nThe youngest friend is: " + YoungestFriend + " with age " + YoungestAge + " years.");
        System.out.println("The tallest friend is: " + tallestFriend + " with height " + tallestHeight + " cm.");

        sc.close();
    }
}
