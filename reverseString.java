package AssignmentStringBuilderStringBuffer;
import java.util.Scanner;
public class reverseString
{
    public static String reverse(String input)
    {
        StringBuilder sb = new StringBuilder(input);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        System.out.println("Reversed string: " + reverse(input));
        sc.close();
    }
}







