package converters;
import ascii.AsciiUtils;
import ascii.CleanInput;
import ascii.Parsing;

import java.util.ArrayList;
import java.util.List;

public class BinaryConverter implements IConverter {
    public BinaryConverter() {}

    private String decimalToBinary(Integer decimal_value) {
        StringBuilder binary_string = new StringBuilder();
        Integer remainder = 0;
        while (decimal_value > 0) {
            remainder = decimal_value % 2;
            binary_string.insert(0, remainder);
            decimal_value = decimal_value / 2;
        }
        return binary_string.toString();
    }

    private Integer binaryToDecimal(String binary_string) {
        Integer result = 0;
        for (Integer index = binary_string.length() - 1; index >= 0; index--) {
            if (binary_string.charAt(index) != '0') {
                result += 1 << binary_string.length() - 1 - index;
            }
        }
        return result;
    }

    @Override
    public String conversion(String input_user) {
        List<List<Integer>> parsed_user_string = Parsing.parseGroupNumbers(input_user);
        StringBuilder user_input_ascii = new StringBuilder();
        for (List<Integer> group_number : parsed_user_string) {
            StringBuilder int_string = new StringBuilder();
            for (Integer ascii_value : group_number) {
                int_string.append(this.decimalToBinary(ascii_value));
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
        for (List<String> group: convertedInput) {
            for (String binary_string : group) {
                final_string.append(this.binaryToDecimal(binary_string));
                final_string.append(" ");
            }
            final_string.append(" ");
        }
        return final_string.toString();
    }
}