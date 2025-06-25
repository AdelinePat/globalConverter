package converters;

import ascii.AsciiUtils;
import custom_exceptions.AlgorithmError;
import java.util.ArrayList;
import java.util.List;

public class DecimalConverter implements IConverter {
    public List<List<Integer>> conversion(List<List<String>> parsed_user_string) throws AlgorithmError {
        List<List<Integer>> result = null;
        try {
            result = new ArrayList<>();
            for (List<String> word : parsed_user_string) {
                List<Integer> ascii_values = new ArrayList<>();
                for (String c : word) {
                    Integer ascii_code = AsciiUtils.ascii_map.get(c);
                    ascii_values.add(ascii_code);
                    if (ascii_code == null) {
                       throw new AlgorithmError("Le code ASCII est NULL ou" +
                                "non trouvé dans ascii_table.json");
                    }
                }
                result.add(ascii_values);
            }

        } catch (AlgorithmError e) {
            System.out.println("\u001B[31mErreur d'Algorithme : \u001B[0m" + e.getMessage());
        }
        return result;
    }

    public List<List<String>>  reverseConversion(List<List<Integer>> convertedInput) {
        List<List<String>>  final_string = new ArrayList<>();
        try {
            for (List<Integer> word : convertedInput) {
                List<String> word_string = new ArrayList<>();
                for (Integer character : word) {
                    String letter = AsciiUtils.getCharacterByAsciiValue(character);
                    word_string.add(letter);
                }
                final_string.add(word_string);
            }
        } catch (AlgorithmError e) {
            System.out.println("\u001B[31mErreur d'Algorithme : \u001B[0m" + e.getMessage());
        }
        return final_string;
    }
}
