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

    public HexaConverter() {
        System.out.println("\n***** HexaConverter constructor lol *****\n");
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

    @Override
    public String conversion(String input_user) throws AlgorithmError {
        List<List<String>> parsed_user_string = AsciiUtils.parseStringIntoStringList(input_user);
        List<String> result = new ArrayList<>();

        try {
            for (List<String> word : parsed_user_string) {
                for (String c : word) {
                    Integer ascii_code = AsciiUtils.ascii_map.get(c);
                    if (ascii_code == null) {
                        throw new AlgorithmError("Le code ASCII est NULL ou non trouvé dans ascii_table.json");
                    }
                    String hex_code = decimalToHexManual(ascii_code);
                    result.add(hex_code);
                }

                result.add("");
            }
        } catch (AlgorithmError e) {
            System.out.println("\u001B[31mErreur d'Algorithme : \u001B[0m" + e.getMessage());
        }


        return String.join(" ", result).trim();
    }


    @Override
    public String reverseConversion(String user_input_hex) {
        String[] hexCodes = user_input_hex.trim().split(" ", -1);
        List<String> currentWord = new ArrayList<>();
        List<String> fullMessage = new ArrayList<>();

        try {
            for (String hexCode : hexCodes) {
                if (hexCode.isEmpty()) {
                    // Fin d'un mot, on l'ajoute à la liste et on réinitialise
                    fullMessage.add(String.join("", currentWord));
                    currentWord.clear();
                    continue;
                }

                int decimalValue = 0;
                for (int i = 0; i < hexCode.length(); i++) {
                    String hexChar = hexCode.substring(i, i + 1).toUpperCase();
                    Integer val = hexToInt.get(hexChar);
                    if (val == null) {
                        throw new AlgorithmError("Caractère hexadécimal invalide : " + hexChar);
                    }
                    decimalValue = decimalValue * 16 + val;
                }

                String letter = AsciiUtils.getCharacterByAsciiValue(decimalValue);
                currentWord.add(letter);
            }

            // Ajouter le dernier mot s’il n’y a pas d’espace final
            if (!currentWord.isEmpty()) {
                fullMessage.add(String.join("", currentWord));
            }

        } catch (AlgorithmError e) {
            System.out.println("\u001B[31mErreur d'Algorithme : \u001B[0m" + e.getMessage());
        }

        // Rejoint les mots avec un seul espace
        return String.join(" ", fullMessage);
    }


}
