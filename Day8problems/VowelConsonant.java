import java.util.Scanner ;
public class VowelConsonant {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        input = input.toLowerCase();
        int vowelCount = 0, consonantCount = 0;
        String vowels = "aeiou";
               for (char ch : input.toCharArray())
 {
            if (Character.isLetter(ch)) 
{
                if (vowels.indexOf(ch) != -1)
 {
                    vowelCount++;
                }
 else 
{
                    consonantCount++;
                }
            }
        }

        System.out.println("Number of vowels: " + vowelCount);
        System.out.println("Number of consonants: " + consonantCount);
        scanner.close();
    }
}

