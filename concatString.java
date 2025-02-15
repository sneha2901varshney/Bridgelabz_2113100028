package AssignmentStringBuilderStringBuffer;

import java.util.Scanner;

public class concatString {
    public static String concatenateStrings(String[] strings) {
        StringBuffer sb = new StringBuffer();

        for (String str : strings) {
            sb.append(str);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of strings: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        String[] strings = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter string " + (i + 1) + ": ");
            strings[i] = scanner.nextLine();
        }

        System.out.println("Concatenated string: " + concatenateStrings(strings));
        scanner.close();
    }
}

