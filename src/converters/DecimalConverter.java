package converters;

import utils.AsciiUtils;
import utils.Parsing;
import custom_exceptions.AlgorithmError;
import java.util.ArrayList;
import java.util.List;

public class DecimalConverter implements IConverter {
    public String conversion(String input_user) throws AlgorithmError {
        List<List<String>> parsed_user_string = Parsing.splitSentenceIntoLetterGroups(input_user);
//        List<List<Integer>> result = new ArrayList<>();
        StringBuilder result = new StringBuilder();
        try {
            for (List<String> word : parsed_user_string) {
//                List<Integer> ascii_values = new ArrayList<>();
                StringBuilder ascii_values = new StringBuilder();
                for (String c : word) {
                    Integer ascii_code = AsciiUtils.ascii_map.get(c);
                    ascii_values.append(ascii_code);
                    ascii_values.append(" ");
                    if (ascii_code == null) {
                       throw new AlgorithmError("Le code ASCII est NULL ou" +
                                "non trouvé dans ascii_table.json");
                    }
                }
                result.append(ascii_values);
                result.append(" ");
            }
        } catch (AlgorithmError e) {
            System.out.println("\u001B[31mErreur d'Algorithme : \u001B[0m" + e.getMessage());
        }
        return result.toString();
    }

    public String reverseConversion(String user_input_int) {
        List<List<Integer>> convertedInput = Parsing.parseGroupNumbers(user_input_int);
        StringBuilder final_string = new StringBuilder();
        try {
            for (List<Integer> word : convertedInput) {
                StringBuilder word_string = new StringBuilder();
                for (Integer character : word) {
//                    String letter = AsciiUtils.getCharacterByAsciiValue(character);
                    String letter = AsciiUtils.reverse_ascii_map.get(character);
                    if (letter == null) {
                        throw new AlgorithmError("Le code ASCII est NULL ou non trouvé dans ascii_table.json");
                    }
                    word_string.append(letter);
                }
                final_string.append(word_string);
                final_string.append(" ");
            }
        } catch (AlgorithmError e) {
            System.out.println("\u001B[31mErreur d'Algorithme : \u001B[0m" + e.getMessage());
        }
        return final_string.toString();
    }
}
