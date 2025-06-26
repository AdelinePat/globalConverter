package converters;
import ascii.AsciiUtils;
import ascii.CleanInput;
import ascii.Parsing;

import java.util.ArrayList;
import java.util.List;

public class BinaryConverter implements IConverter {
    public BinaryConverter() {
        System.out.println("\n***** BinaryConverter constructor lol *****\n");
    }

    @Override
    public String conversion(String input_user) {
        List<List<Integer>> parsed_user_string = Parsing.parseGroupNumbers(input_user);
        System.out.println("dans binaire conversion : " + parsed_user_string);
//        List<List<String>> user_input_ascii = new ArrayList<>();
        StringBuilder user_input_ascii = new StringBuilder();

        for (List<Integer> group_number : parsed_user_string) {
            StringBuilder int_string = new StringBuilder();
            List<String> ascii_string_bin = new ArrayList<>();
            for (Integer ascii_value : group_number) {
//                ascii_string_bin.add(this.conversion(ascii_value));
                int_string.append(this.conversion(ascii_value));
                int_string.append(" ");
            }
            user_input_ascii.append(int_string);
            user_input_ascii.append(" ");

//            ascii_string_bin.add(this.conversion(CleanInput.stringToInt(int_string.toString())));
//            user_input_ascii.add(ascii_string_bin);
        }
//        return AsciiUtils.concatenateFromString(user_input_ascii);
        return user_input_ascii.toString();
    }

    @Override
    public String reverseConversion(String user_input_int) {
        List<List<String>> convertedInput = Parsing.parseGroupStrings(user_input_int);
        System.out.println("list de list de string début reverse conversion : " + convertedInput);
        StringBuilder final_string = new StringBuilder();

        for (List<String> group: convertedInput) {
            for (String binaryStr : group) {
                Integer result = 0;
                for (Integer index = binaryStr.length() - 1; index >= 0; index--) {
                    if (binaryStr.charAt(index) != '0') {
                        result += 1 << binaryStr.length() - 1 - index;
                    }
                }
                final_string.append(String.valueOf(result));
                final_string.append(String.valueOf(" "));
            }
            final_string.append(" ");
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