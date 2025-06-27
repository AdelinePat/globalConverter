package converters;

import utils.AsciiUtils;
import utils.CleanInput;
import utils.Parsing;
import custom_exceptions.AlgorithmError;

import java.util.ArrayList;
import java.util.List;

public class OctalConverter implements IConverter {
    public OctalConverter() {}

        @Override
        public String conversion(String input_user) {
            List<List<String>> parsed_user_string = Parsing.splitSentenceIntoLetterGroups(input_user);
            StringBuilder return_string = new StringBuilder();

            for (int list_index = 0; list_index < parsed_user_string.size(); list_index++) {

                for (String letter : parsed_user_string.get(list_index)) {
                    Integer ascii_code = AsciiUtils.ascii_map.get(letter);
                    return_string.append(this.conversion(ascii_code));
                    return_string.append(" ");
                }
                if (list_index != parsed_user_string.size() - 1) {
                    return_string.append(" ");
                }
            }
            return return_string.toString().trim();
        }

        @Override
        public String reverseConversion(String user_input_int) {
            List<List<Integer>> parsed_user_string = Parsing.parseGroupNumbers(user_input_int);

            StringBuilder return_string = new StringBuilder();
            try {
                for (Integer list_index = 0; list_index < parsed_user_string.size(); list_index++) {

                    for (Integer letter : parsed_user_string.get(list_index)) {
                        Integer decimal_value = CleanInput.stringToInt(this.reverseConversion(letter));
//                        String ascii_letter = AsciiUtils.getCharacterByAsciiValue(decimal_value);
                        String ascii_letter = AsciiUtils.reverse_ascii_map.get(decimal_value);
                        if (letter == null) {
                            throw new AlgorithmError("Le code ASCII est NULL ou non trouvé dans ascii_table.json");
                        }
                        return_string.append(ascii_letter);
                    }
                    if (list_index != parsed_user_string.size() - 1) {
                        return_string.append(" ");
                    }
                }
            } catch (AlgorithmError e) {
                System.out.println("\u001B[31mErreur d'Algorithme : \u001B[0m" + e.getMessage());
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