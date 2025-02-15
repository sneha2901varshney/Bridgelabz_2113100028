package AssignmentStringBuilderStringBuffer;
import java.util.Scanner;
public class removeDuplicate
{
    public static String remove(String st) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < st.length(); i++) {
            char c =st.charAt(i);
            if (sb.indexOf(String.valueOf(c)) == -1) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String st = scanner.nextLine();
        System.out.println("String without duplicates: " + remove(st));
        scanner.close();
    }
}
