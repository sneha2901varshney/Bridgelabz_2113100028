public class RemoveCharacter {
    public static void main(String[] args) {
        String str = "Hello World";
        char charToRemove = 'l';
        System.out.println("String after removal: " + removeCharacter(str, charToRemove));
    }

    public static String removeCharacter(String str, char charToRemove) {
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != charToRemove) {
                result.append(str.charAt(i));
            }
        }
        
        return result.toString();
    }
}

