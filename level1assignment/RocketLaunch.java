
import java.util.Scanner;

public class RocketLaunch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       
        System.out.print("Enter the countdown start value: ");
        int counter = scanner.nextInt();
       
        while (counter >= 1) {
            System.out.println(counter);
            counter--;
        }
       
        System.out.println("Liftoff!");
        scanner.close();
    }
}

