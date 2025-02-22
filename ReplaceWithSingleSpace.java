package AssignmentRegex;
import java.util.regex.Pattern;
public class ReplaceWithSingleSpace {

    public static void main(String[] args) {
        String input = "This       is an example with        multiple      spaces.";

        String result = input.replaceAll("\\s+", " ");

        System.out.println("Before: " + input);
        System.out.println("After: " + result);
    }
}

