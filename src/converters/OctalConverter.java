package converters;

import ascii.AsciiUtils;

import java.util.ArrayList;
import java.util.List;

public class OctalConverter implements IConverter {
    public OctalConverter() {
        // this is a constructor, I swear
        System.out.println("\n***** OctalConverter constructor lol *****\n");
    }

        @Override
        public String conversion(String input_user) {
            List<List<String>> parsed_user_string = AsciiUtils.parseStringIntoStringList(input_user);
            List<List<Integer>> user_input_ascii = new ArrayList<>();
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
    }