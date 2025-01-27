import java.util.Scanner;

public class Frequency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        String number = sc.next();
        int[] freq = new int[10];
        
        for (int i = 0; i < number.length(); i++) {
            int digit = number.charAt(i) - '0';
            freq[digit]++;
        }
        
        for (int i = 0; i < 10; i++) {
            if (freq[i] > 0) {
                System.out.println(i + " appears " + freq[i] + " times");
            }
        }
    }
}
