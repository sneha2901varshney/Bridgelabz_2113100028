package AssignmentCollectionFramework;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringFrequencyCounter {
    public static Map<String, Integer> countFrequency(List<String> words) {
        Map<String, Integer> frequency = new HashMap<>();

        for (String word : words) {
            frequency.put(word, frequency.getOrDefault(word, 0) + 1);
        }

        return frequency;
    }

    public static void main(String[] args) {
        List<String> words = List.of("apple", "banana", "apple", "orange", "plum","cherry");
        Map<String, Integer> result = countFrequency(words);

        System.out.println(result);
    }
}
