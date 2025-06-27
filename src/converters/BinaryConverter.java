package converters;
import utils.AsciiUtils;
import utils.Parsing;
import custom_exceptions.AlgorithmError;

import java.util.List;

public class BinaryConverter implements IConverter {
    public BinaryConverter() {}

    private String fromDecimalToBinary(Integer decimal_value) {
        if (decimal_value == 0) return "0";

        StringBuilder binary_string = new StringBuilder();

        while (decimal_value > 0) {
            int remainder =  decimal_value % 2;
            binary_string.insert(0, remainder);
            decimal_value /= 2;
        }
        return binary_string.toString();
    }

    private Integer fromBinaryToDecimal(String binary_string) {
        Integer result = 0;
        for (Integer index = binary_string.length() - 1; index >= 0; index--) {
            if (binary_string.charAt(index) != '0') {
                result += 1 << binary_string.length() - 1 - index;
            }
        }
        return result;
    }

    @Override
    public String conversion(String input_user) throws AlgorithmError {
        List<List<String>> parsed_user_string = Parsing.splitSentenceIntoLetterGroups(input_user);
        StringBuilder user_input_ascii = new StringBuilder();

        for (List<String> word : parsed_user_string) {
            StringBuilder int_string = new StringBuilder();

            for (String c : word) {
                Integer ascii_code = AsciiUtils.getAsciiCode(c);
                int_string.append(this.fromDecimalToBinary(ascii_code));
                int_string.append(" ");
            }
            user_input_ascii.append(int_string);
            user_input_ascii.append(" ");
        }
        return user_input_ascii.toString();
    }

    @Override
    public String reverseConversion(String user_input_int) {
        List<List<String>> convertedInput = Parsing.parseGroupStrings(user_input_int);
        StringBuilder final_string = new StringBuilder();
        try {
            for (List<String> group: convertedInput) {
                for (String binary_string : group) {
                    Integer result = this.fromBinaryToDecimal(binary_string);
//                    String letter = AsciiUtils.reverse_ascii_map.get(result);
                    String letter = AsciiUtils.getCharacterFromAscii(result);
//                    if (letter == null) {
//                        throw new AlgorithmError("Le code ASCII est NULL ou non trouvé dans ascii_table.json");
//                    }
                    final_string.append(letter);
                }
                final_string.append(" ");
            }
        } catch (AlgorithmError e) {
            System.out.println("\u001B[31mErreur d'Algorithme : \u001B[0m" + e.getMessage());
        }
        return final_string.toString();
    }
}