public class WordReplacer {
    public static void main(String[] args) {
        String sentence = "Hello, this is a simple sentence.";
        String wordToReplace = "simple";
        String replacementWord = "complex";
        System.out.println("Updated Sentence: " + replaceWord(sentence, wordToReplace, replacementWord));
    }

    public static String replaceWord(String sentence, String wordToReplace, String replacementWord) {
        return sentence.replaceAll("\\b" + wordToReplace + "\\b", replacementWord);
    }
}

