package caesar;

import ascii.AsciiUtils;

import java.util.ArrayList;
import java.util.List;

public class  CaesarCipher {
    private Integer key;

    public String caesarEncrypt(String user_input_int) {
        return caesarEncrypt(user_input_int, 0);
    }

    public String caesarEncrypt(String user_input_int, int offset) {
        List<List<Integer>> initialDecimalValues = AsciiUtils.parseStringIntoIntList(user_input_int);

        if (offset != 0) {
            key = offset;
        } else {
            key = -key;
        }
        List<List<Integer>> result = new ArrayList<>();

        for (List<Integer> integers_group : initialDecimalValues) {

            List<Integer> word_result = new ArrayList<>();

            for (int new_value : integers_group) {
                word_result.add(getNewValue(new_value));
            }
            result.add(word_result);
        }
        return AsciiUtils.concatenateFromInt(result);
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
