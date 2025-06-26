package ascii;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import custom_exceptions.AlgorithmError;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class AsciiUtils {

    public static Map<String, Integer> ascii_map;
    static {
        loadAsciiTable();
    }

    private static void loadAsciiTable() {
        InputStream inputStream = AsciiUtils.class.getResourceAsStream("/ascii_table.json");

        if (inputStream == null) {
            System.out.println("File not found! Please check the path.");
            return; // ERROR TO MANAGE !
        }
        InputStreamReader reader = new InputStreamReader(inputStream);
        Gson gson = new Gson();
        ascii_map = gson.fromJson(reader, new TypeToken<Map<String, Integer>>() {}.getType());
    }

    public static List<String> parseStringIntoList(String user_input) {
//        List<String> result = new ArrayList<>();
        String[] words = user_input.split(" ");
        return Arrays.asList(words);
    }

    public static List<List<String>> parseStringIntoListList(String user_input) {
        List<List<String>> result = new ArrayList<>();
        List<String> word = parseStringIntoList(user_input);
        List<String> second_list = new ArrayList<>();
        for (String letter : word) {
            result.add(List.of(letter));
        }
        return result;
    }

    public static List<List<String>> parseStringIntoStringList(String user_input) {
        List<List<String>> result = new ArrayList<>();
        String[] words = user_input.split(" ");


        for (String word : words) {
            List<String> ascii_letters = new ArrayList<>();
            for (char c : word.toCharArray()) {
                ascii_letters.add(String.valueOf(c));
            }
            result.add(ascii_letters);
        }
        result.removeIf(List::isEmpty);
        return result;
    }
    public static List<List<Integer>> parseStringIntoIntList(String user_input_decimal, Integer choice) {
        List<List<Integer>> result = new ArrayList<>();
        String[] words = user_input_decimal.split(" ");

        for (String word : words) {
            List<Integer> group_numbers = new ArrayList<>();
            for (int index = 0; index < word.length(); index++) {
                group_numbers.add(CleanInput.stringToInt(String.valueOf(word.charAt(index))));
            }
            result.add(group_numbers);
        }
        return result;
    }
    public static List<List<Integer>> parseStringIntoIntList(String user_input_decimal) {
        List<List<Integer>> result = new ArrayList<>();
        String[] words = user_input_decimal.split("  ");

        for (String word : words) {
            List<Integer> group_numbers = new ArrayList<>();
            String[] letter_list = word.split(" ");
            for (String c : letter_list) {
                group_numbers.add(CleanInput.stringToInt(c));
            }
            result.add(group_numbers);
        }
        return result;
    }

    public static String getCharacterByAsciiValue(Integer ascii_value) throws AlgorithmError {
        for (Map.Entry<String, Integer> entry : ascii_map.entrySet()) {
            if (entry.getValue().equals(ascii_value)) {
                return entry.getKey();
            }
        }
        throw new AlgorithmError("Attention, la valeur ASCII n'a pas de clé " +
                "correspondante dans le ascii_table.json.");
    }

    public static String concatenateFromInt(List<List<Integer>> convertedInput){
        StringBuilder final_string = new StringBuilder();
        for (List<Integer> word : convertedInput) {
            StringBuilder ascii_string = new StringBuilder();
            for (int index=0; index < word.size(); index++) {
                String character = word.get(index).toString();
                ascii_string.append(character);
                if (index != word.size() -1 ) {
                    ascii_string.append(" ");
                }
            }
            final_string.append(ascii_string);
            final_string.append("  ");
        }
        return final_string.toString().trim();
    }

    public static String concatenateFromString(List<List<String>> convertedInput) {
        StringBuilder final_string = new StringBuilder();
        for (List<String> word : convertedInput) {
            StringBuilder ascii_string = new StringBuilder();
            for (String character : word) {
                ascii_string.append(character);
            }
            final_string.append(ascii_string);
            final_string.append(" ");
        }
        return final_string.toString().trim();
    }
}
