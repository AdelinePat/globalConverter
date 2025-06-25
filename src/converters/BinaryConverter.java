package converters;
import ascii.AsciiUtils;
import ascii.CleanInput;

import java.util.ArrayList;
import java.util.List;

public class BinaryConverter implements IConverter {
    public BinaryConverter() {
        System.out.println("\n***** BinaryConverter constructor lol *****\n");
    }

    @Override
    public String conversion(String input_user) {
        List<List<String>> parsed_user_string = AsciiUtils.parseStringIntoStringList(input_user);
        List<List<String>> user_input_ascii = new ArrayList<>();

        for (List<String> word : parsed_user_string) {
            StringBuilder int_string = new StringBuilder();
            List<String> ascii_string_bin = new ArrayList<>();
            for (String letter : word) {
                int_string.append(letter);
            }

            ascii_string_bin.add(this.conversion(CleanInput.stringToInt(int_string.toString())));
            user_input_ascii.add(ascii_string_bin);
        }
        return AsciiUtils.concatenateFromString(user_input_ascii);
    }

    @Override
    public String reverseConversion(String user_input_int) {
        List<List<Integer>> convertedInput = AsciiUtils.parseStringIntoIntList(user_input_int, 0);
        StringBuilder final_string = new StringBuilder();
        for (List<Integer> value: convertedInput) {
            Integer result = 0;
            List<Integer> reversed_value = value.reversed();
            for (Integer index = 0; index < reversed_value.size(); index++) {
                if (reversed_value.get(index) != 0) {
                    result += 1 << index;
                }
            }
            final_string.append(result);
            final_string.append(" ");
//            System.out.println("Valeur : " + result);
//            System.out.println(reversed_value);
        }

        // impementation for this method : probably needs to call for concatenateString to return it
        return final_string.toString();
    }

    private String conversion(Integer decimal_value) {
//        Integer n = this.findBiggestPowerOfTwo(decimal_value);
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