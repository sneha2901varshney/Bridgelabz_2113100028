import java.util,* ;
public class MostFrequentCharacter {
    public static void main(String[] args) {
        String str = "success";
        System.out.println("Most frequent character: " + mostFrequentCharacter(str));
    }

    public static char mostFrequentCharacter(String str) {
        int[] freqArray = new int[256]; // Array to store frequency of each character (assuming ASCII characters)
        for (int i = 0; i < str.length(); i++) {
            freqArray[str.charAt(i)]++;
        }

        char maxChar = str.charAt(0);
        int maxCount = 0;
        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            if (freqArray[currentChar] > maxCount) {
                maxCount = freqArray[currentChar];
                maxChar = currentChar;
            }
        }

        return maxChar;
    }
}

