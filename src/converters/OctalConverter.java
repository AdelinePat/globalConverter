package converters;

import java.util.ArrayList;
import java.util.List;

public class OctalConverter implements IConverter {
    public OctalConverter() {
        // this is a constructor, I swear
        System.out.println("\n***** OctalConverter constructor lol *****\n");
    }

        @Override
        public List<List<Integer>> conversion(List<List<String>> parsed_user_string) {
            List<List<Integer>> user_input_ascii = new ArrayList<>();
            // implemetation for this part, probably needs another method to parse string into list of list
            return user_input_ascii;
        }

        @Override
        public List<List<String>> reverseConversion(List<List<Integer>> convertedInput) {
            List<List<String>> back_to_user_input = new ArrayList<>();
            // impementation for this method : probably needs to call for concatenateString to return it
            return back_to_user_input;
        }
    }