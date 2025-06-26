package converters;
import ascii.AsciiUtils;
import ascii.CleanInput;
import ascii.Parsing;
import custom_exceptions.AlgorithmError;

import java.util.ArrayList;
import java.util.List;

public class BinaryConverter implements IConverter {
    public BinaryConverter() {
        System.out.println("\n***** BinaryConverter constructor lol *****\n");
    }

    @Override
    public String conversion(String input_user) throws AlgorithmError {
        System.out.println(">>>> refactoring ici");
//        List<List<Integer>> parsed_user_string = Parsing.parseGroupNumbers(input_user);
        List<List<String>> parsed_user_string = Parsing.splitSentenceIntoLetterGroups(input_user);

        StringBuilder user_input_ascii = new StringBuilder();

        for (List<String> word : parsed_user_string) {
            StringBuilder int_string = new StringBuilder();
            List<String> ascii_string_bin = new ArrayList<>();

            for (String c : word) {
                Integer ascii_code = AsciiUtils.ascii_map.get(c);
                if (ascii_code == null) {
                    throw new AlgorithmError("Le code ASCII est NULL ou non trouvé dans ascii_table.json");
                }
                int_string.append(this.conversion(ascii_code));
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
                for (String binaryStr : group) {
                    Integer result = 0;
                    for (Integer index = binaryStr.length() - 1; index >= 0; index--) {
                        if (binaryStr.charAt(index) != '0') {
                            result += 1 << binaryStr.length() - 1 - index;
                        }
                    }
                    final_string.append(AsciiUtils.getCharacterByAsciiValue(result));
//                    final_string.append(" ");
                }
                final_string.append(" ");
            }

        } catch (AlgorithmError e) {
            System.out.println("\u001B[31mErreur d'Algorithme (reversebin): \u001B[0m" + e.getMessage());
        }
        return final_string.toString();
    }

    private String conversion(Integer decimal_value) {
        List<Integer> bit_positions = new ArrayList<>();
        List<Integer> final_bit_value = new ArrayList<>();
        Integer original_value = decimal_value;
        StringBuilder decimal_string = new StringBuilder();

        while (decimal_value > 0) {
            Integer n = this.findBiggestPowerOfTwo(decimal_value);
            bit_positions.add(n);
            decimal_value -= (1 << n);
        }

        Integer highest_bit = this.findBiggestPowerOfTwo(original_value);
        for (Integer index = highest_bit; index >= 0; index--) {
            if (bit_positions.contains(index)) {
                decimal_string.append("1");
                final_bit_value.add(1);
            } else {
                decimal_string.append("0");
                final_bit_value.add(0);
            }
        }
        return decimal_string.toString();
    }

    private Integer findBiggestPowerOfTwo(Integer value) {
        Integer n = 0;
        while (1 << (n+1) <= value) {
            n++;
        }
        return n;
    }
}