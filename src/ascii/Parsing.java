package ascii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Parsing {
    public static List<String> splitSentenceIntoWords(String user_input) {
        return new ArrayList<>(Arrays.asList(user_input.trim().split(" ")));
    }

    public static List<String> splitWordIntoLetters(String word) {
        List<String> letters = new ArrayList<>();
        for (char c : word.toCharArray()) {
            letters.add(String.valueOf(c));
        }
        return letters;
    }

    public static List<List<String>> splitSentenceIntoLetterGroups(String user_input) {
        List<List<String>> result = new ArrayList<>();
        for (String word: splitSentenceIntoWords(user_input)) {
            result.add(splitWordIntoLetters(word));
        }
        return result;
    }

    public static List<List<Integer>> parseGroupNumbers(String user_input) {
        List<List<Integer>> result = new ArrayList<>();
        String[] words = user_input.split(" {2}");
        for (String word: words) {
            List<Integer> numbers = new ArrayList<>();
            String[] parts = word.trim().split(" ");

            for (String part : parts) {
                if (!part.isEmpty()) {
                    numbers.add(Integer.parseInt(part));
                }
            }
            result.add(numbers);
        }
        return result;
    }

    public static List<List<String>> parseGroupStrings(String user_input) {
        List<List<String>> result = new ArrayList<>();
        String[] words = user_input.split(" {2}"); // double space = word split

        for (String word : words) {
            List<String> group = new ArrayList<>();
            String[] parts = word.trim().split(" "); // single space = number split
            for (String part : parts) {
                if (!part.isEmpty()) {
                    group.add(part); // keep as string
                }
            }
            result.add(group);
        }

        return result;
    }
}
