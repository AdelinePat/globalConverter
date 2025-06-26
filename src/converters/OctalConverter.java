package converters;

import ascii.AsciiUtils;
import ascii.Parsing;

import java.util.ArrayList;
import java.util.List;

public class OctalConverter implements IConverter {
    public OctalConverter() {
        // this is a constructor, I swear
        System.out.println("\n***** OctalConverter constructor lol *****\n");
    }

        @Override
        public String conversion(String input_user) {
//            List<List<Integer>> parsed_user_string = AsciiUtils.parseStringIntoIntList(input_user);
            List<List<Integer>> parsed_user_string = Parsing.parseGroupNumbers(input_user);

            StringBuilder return_string = new StringBuilder();

            for (int list_index = 0; list_index < parsed_user_string.size(); list_index++) {

                for (int letter : parsed_user_string.get(list_index)) {
                    return_string.append(conversion(letter));

                    if (parsed_user_string.get(list_index).indexOf(letter) != parsed_user_string.get(list_index).size() - 1) {
                        return_string.append(" ");
                    }
                }
                if (list_index != parsed_user_string.size() - 1) {
                    return_string.append("  ");
                }
            }

            return return_string.toString();
        }

        @Override
        public String reverseConversion(String user_input_int) {

            List<List<Integer>> parsed_user_string = AsciiUtils.parseStringIntoIntList(user_input_int);
//            List<List<String>> parsed_user_string = Parsing.parseGroupStrings(user_input_int);

            StringBuilder return_string = new StringBuilder();

            for (int list_index = 0; list_index < parsed_user_string.size(); list_index++) {

                for (int letter : parsed_user_string.get(list_index)) {

                    return_string.append(reverseConversion(letter));

                    if (parsed_user_string.get(list_index).indexOf(letter) != parsed_user_string.get(list_index).size() - 1) {
                        return_string.append(" ");
                    }
                }
                if (list_index != parsed_user_string.size() - 1) {
                    return_string.append("  ");
                }
            }

            return return_string.toString();
        }

        private String conversion(Integer decimal_value) {

            int divided_value = decimal_value;
            List<Integer> octal_result = new ArrayList<>();

            while (divided_value != 0) {
                int result = divided_value % 8;
                divided_value /= 8;
                octal_result.add(result);
            }

            List<Integer>return_list_int = octal_result.reversed();
            StringBuilder return_value = new StringBuilder();

            for (int values :  return_list_int) {
                return_value.append(values);
            }

            return return_value.toString();
        }

        private String reverseConversion(Integer octal_value) {

            int divided_value =  octal_value;
            int factor = 1;
            int octal_result = 0;

            while (divided_value != 0) {
                octal_result += (divided_value % 10) * factor;
                divided_value /= 10;
                factor *= 8;
            }

            return Integer.toString(octal_result);
        }
    }