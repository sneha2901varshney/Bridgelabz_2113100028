import java.util.Scanner;

public class Handshakes2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of Students: ");
        double numberOfStudents = sc.nextDouble();

        double handshake = (numberOfStudents * (numberOfStudents - 1)) / 2 ;

        System.out.println("The total number of possible handshakes are " + handshake);
    }
}