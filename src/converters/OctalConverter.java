package converters;

import java.util.ArrayList;
import java.util.List;

public class OctalConverter implements IConverter {
    public OctalConverter() {
        // this is a constructor, I swear
        System.out.println("\n***** OctalConverter constructor lol *****\n");
    }

        @Override
        public List<List<Integer>> conversion(List<List<Integer>> parsed_user_string) {
            List<List<Integer>> user_input_ascii = new ArrayList<>();
            // implemetation for this part, probably needs another method to parse string into list of list
            return user_input_ascii;
        }

        @Override
        public String reverseConversion(List<List<Integer>> convertedInput) {
            String back_to_user_input = new String();
            // impementation for this method : probably needs to call for concatenateString to return it
            return  back_to_user_input;
        }
        @Override
        public String concatenateString(List<List<Integer>> convertedInput) {
            String list_to_string = new String();
            // needs to get each element of each list and put them back as a "list of word" and create final string
            return  list_to_string;
        }
        @Override
        public List<List<Integer>> parseStringIntoInt(String user_input) {
            List<List<Integer>> user_input_ascii = new ArrayList<>();
        /* parse all the word into list of words and then each word are a
        list of letter so we can treat each letter as an unique value */
            return user_input_ascii;

        }
    }