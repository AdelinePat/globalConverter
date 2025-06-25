package ascii;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import custom_exceptions.AlgorithmError;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AsciiUtils {

    public static Map<String, Integer> ascii_map;
    static {
        loadAsciiTable();
    }

    private static void loadAsciiTable() {

//        InputStream inputStream = getClass().getResourceAsStream("/ascii_table.json");
        InputStream inputStream = AsciiUtils.class.getResourceAsStream("/ascii_table.json");

        if (inputStream == null) {
            System.out.println("File not found! Please check the path.");
            return; // Exit or handle the error
        }
        InputStreamReader reader = new InputStreamReader(inputStream);
        Gson gson = new Gson();
        ascii_map = gson.fromJson(reader, new TypeToken<Map<String, Integer>>() {}.getType());
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
            for (Integer character : word) {
                ascii_string.append(character.toString());
                ascii_string.append(" ");
            }
            final_string.append(ascii_string);
            final_string.append(" ");
        }
        return final_string.toString().trim();
    }

    public static String concatenateFromString(List<List<String>> convertedInput) throws AlgorithmError {
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
