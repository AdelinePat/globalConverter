package converters;

import ascii.AsciiUtils;
import custom_exceptions.AlgorithmError;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HexaConverter implements IConverter {

    private static final Map<String, Integer> hexToInt = new HashMap<>();
    private static final Map<String, String> intToHex = new HashMap<>();

    static {
        // HEX_TO_INT
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

        // INT_TO_HEX
        for (Map.Entry<String, Integer> entry : hexToInt.entrySet()) {
            intToHex.put(entry.getValue().toString(), entry.getKey());
        }
    }

    public HexaConverter() {
        // this is a constructor,
        System.out.println("\n***** HexaConverter constructor lol *****\n");
    }

    // méthod for convert hex in int
    private String decimalToHexManual(int value) {
        if (value == 0) {
            return "0";
        }
        StringBuilder hex = new StringBuilder();
        while (value > 0) {
            int remainder = value % 16;
            String hexDigit = intToHex.get(Integer.toString(remainder)); // utilisation de la map
            hex.insert(0, hexDigit);
            value /= 16;
        }
        return hex.toString();
    }

    @Override
    public String conversion(String input_user) throws AlgorithmError {
        List<List<String>> parsed_user_string = AsciiUtils.parseStringIntoStringList(input_user);
        List<List<String>> result = new ArrayList<>();

        try {
            for (List<String> word : parsed_user_string) {
                List<String> hex_values = new ArrayList<>();
                for (String c : word) {
                    Integer ascii_code = AsciiUtils.ascii_map.get(c);
                    if (ascii_code == null) {
                        throw new AlgorithmError("Le code ASCII est NULL ou non trouvé dans ascii_table.json");
                    }

                    String hex_code = decimalToHexManual(ascii_code);
                    hex_values.add(hex_code);
                }
                result.add(hex_values);
            }
        } catch (AlgorithmError e) {
            System.out.println("\u001B[31mErreur d'Algorithme : \u001B[0m" + e.getMessage());
        }

        return AsciiUtils.concatenateFromString(result);
    }

    @Override
    public String reverseConversion(String user_input_int) {
        List<List<Integer>> convertedInput = AsciiUtils.parseStringIntoIntList(user_input_int);
        List<List<String>> back_to_user_input = new ArrayList<>();
        // impementation for this method : probably needs to call for concatenateString to return it
        return new String();
    }
}
