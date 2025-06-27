package converters;

import utils.AsciiUtils;
import custom_exceptions.AlgorithmError;
import utils.CleanInput;
import utils.Parsing;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HexaConverter implements IConverter {
    public HexaConverter() {}

    private static final Map<String, Integer> hexToInt = new HashMap<>();
    private static final Map<String, String> intToHex = new HashMap<>();

    static {
        // map hexToInt
        hexToInt.put("0", 0);
        hexToInt.put("1", 1);
        hexToInt.put("2", 2);
        hexToInt.put("3", 3);
        hexToInt.put("4", 4);
        hexToInt.put("5", 5);
        hexToInt.put("6", 6);
        hexToInt.put("7", 7);
        hexToInt.put("8", 8);
        hexToInt.put("9", 9);
        hexToInt.put("A", 10);
        hexToInt.put("B", 11);
        hexToInt.put("C", 12);
        hexToInt.put("D", 13);
        hexToInt.put("E", 14);
        hexToInt.put("F", 15);

        // Filling the intToHex map (inverse mapping)
        for (Map.Entry<String, Integer> entry : hexToInt.entrySet()) {
            intToHex.put(entry.getValue().toString(), entry.getKey());
        }
    }

    // Converts a decimal integer into a hexadecimal string
    private String decimalToHexManual(int value) {
        if (value == 0) {
            return "0";
        }
        StringBuilder hex = new StringBuilder();
        while (value > 0) {
            int remainder = value % 16;
            String hexDigit = intToHex.get(Integer.toString(remainder));
            hex.insert(0, hexDigit);
            value /= 16;
        }
        return hex.toString();
    }

    private Integer fromHexToDecimal (String hex_string) throws AlgorithmError {
        int decimalValue = 0;
        for (int index = 0; index < hex_string.length(); index++) {
            if (hex_string.charAt(index) != '0') {
                String hexChar = String.valueOf(hex_string.charAt(index)).toUpperCase();
                Integer val = this.hexToInt.get(hexChar);
                if (val == null) {
                    throw new AlgorithmError("Caractère hexadécimal invalide : " + hex_string.charAt(index));
                }
                decimalValue =  decimalValue * 16 + val;
            }
        }
        return decimalValue;
    }

    @Override
    public String conversion(String input_user) throws AlgorithmError {
        List<List<String>> parsed_user_string = Parsing.splitSentenceIntoLetterGroups(input_user);
        List<String> result = new ArrayList<>();

        try {
            for (List<String> word : parsed_user_string) {
                for (String c : word) {
                    Integer ascii_code = AsciiUtils.getAsciiCode(c);
                    String hex_code = decimalToHexManual(ascii_code);
                    result.add(hex_code);
                }
                result.add(" ");
            }
        } catch (AlgorithmError e) {
            System.out.println("\u001B[31mErreur d'Algorithme : \u001B[0m" + e.getMessage());
        }
        return String.join(" ", result).trim();
    }

    @Override
    public String reverseConversion(String user_input_hex) {
        List<List<String>> hexCodes = Parsing.parseGroupStrings(user_input_hex);
        StringBuilder final_string = new StringBuilder();

        try {
            for (List<String> hexCode : hexCodes) {
                for (String hex_string: hexCode) {
                    Integer result = this.fromHexToDecimal(hex_string);
                    String letter = AsciiUtils.getCharacterFromAscii(result);
//                    String letter = AsciiUtils.reverse_ascii_map.get(result);
//                    if (letter == null) {
//                        throw new AlgorithmError("Le code ASCII est NULL ou non trouvé dans ascii_table.json");
//                    }
                    final_string.append((letter));
                }
                final_string.append(" ");
            }
        } catch (AlgorithmError e) {
            System.out.println("\u001B[31mErreur d'Algorithme : \u001B[0m" + e.getMessage());
        }
        return final_string.toString();
    }
}
