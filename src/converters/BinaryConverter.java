package converters;
import ascii.AsciiUtils;
import java.util.ArrayList;
import java.util.List;

public class BinaryConverter implements IConverter {
    public BinaryConverter() {
        // this is a constructor, I swear
        System.out.println("\n***** BinaryConverter constructor lol *****\n");
    }

    @Override
    public String conversion(String input_user) {
        List<List<String>> parsed_user_string = AsciiUtils.parseStringIntoStringList(input_user);

        List<List<Integer>> user_input_ascii = new ArrayList<>();
        for (List<String> word : parsed_user_string) {
            for (String letter : word) {
                Integer value = AsciiUtils.ascii_map.get(letter);
//                List<Integer> binary_value = this.conversion(value);

            }
        }
        // implemetation for this part, probably needs another method to parse string into list of list
        return new String();
    }

    @Override
    public String reverseConversion(String user_input_int) {
        List<List<Integer>> convertedInput = AsciiUtils.parseStringIntoIntList(user_input_int);
        List<List<String>> back_to_user_input = new ArrayList<>();
        // impementation for this method : probably needs to call for concatenateString to return it
        return new String();
    }

    private void conversion(int decimal_value) {
        Integer n = 0;
        List<Integer> bit_position = new ArrayList<>();
        while (2 << n < decimal_value) {
            n++;
            if (2 << n + 1 >= decimal_value) {
                bit_position.add(n);
            }
        }
    }
}