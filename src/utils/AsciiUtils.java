package utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import custom_exceptions.AlgorithmError;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AsciiUtils {

    public static Map<String, Integer> ascii_map;
    public static Map<Integer, String> reverse_ascii_map;

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

        reverse_ascii_map = new HashMap<>();
        for (Map.Entry<String, Integer> entry : ascii_map.entrySet()) {
            reverse_ascii_map.put(entry.getValue(), entry.getKey());
        }
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
}
