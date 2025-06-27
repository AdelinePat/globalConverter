package caesar;

import custom_exceptions.AlgorithmError;
import utils.AsciiUtils;
import utils.Parsing;

import java.util.ArrayList;
import java.util.List;

public class  CaesarCipher {
    private Integer key;

    public String caesarEncrypt(String user_input_letter) throws AlgorithmError {
        return caesarEncrypt(user_input_letter, 0);
    }

    public String caesarEncrypt(String user_input_letter, int offset) throws AlgorithmError {
        List<List<String>> initialDecimalValues = Parsing.splitSentenceIntoLetterGroups(user_input_letter);

        if (offset != 0) {
            key = offset;
        } else {
            key = -key;
        }
//        List<List<Integer>> result = new ArrayList<>();
        StringBuilder result = new StringBuilder();

        for (List<String> word : initialDecimalValues) {
            StringBuilder word_result = new StringBuilder();
//            List<Integer> word_result = new ArrayList<>();

            for (String character : word) {
                Integer ascii_code = AsciiUtils.ascii_map.get(character);
                if (ascii_code == null) {
                    throw new AlgorithmError("Le code ASCII est NULL ou non trouvé dans ascii_table.json");
                }
                word_result.append(AsciiUtils.reverse_ascii_map.get((this.getNewValue(ascii_code))));
//                word_result.add(getNewValue(new_value));
            }
            result.append(word_result);
            result.append(" ");
        }
        return result.toString();
    }

    private int getNewValue(int new_value) {
        int min_ascii = 0, max_ascii = 0;

        if (48 <= new_value && new_value <= 57) {
            min_ascii = 48;
            max_ascii = 57;
        }
        else if (65 <= new_value && new_value <= 90) {
            min_ascii = 65;
            max_ascii = 90;
        }
        else if (97 <= new_value && new_value <= 122) {
            min_ascii = 97;
            max_ascii = 122;
        }

        new_value += this.key;

        if (new_value < min_ascii) {
            while (new_value < min_ascii) {
                new_value += max_ascii - min_ascii + 1;
            }
        }
        else if (new_value > max_ascii) {
            while (new_value > max_ascii) {
                new_value -= max_ascii - min_ascii + 1;
            }
        }
        return new_value;
    }
}
