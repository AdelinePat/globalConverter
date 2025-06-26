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
        // Remplissage de la map hexToInt
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

        // Remplissage de la map intToHex (inverse)
        for (Map.Entry<String, Integer> entry : hexToInt.entrySet()) {
            intToHex.put(entry.getValue().toString(), entry.getKey());
        }
    }

    public HexaConverter() {
        System.out.println("\n***** HexaConverter constructor lol *****\n");
    }

    // Convertit un entier décimal en chaîne hexadécimale (sans utiliser les fonctions système)
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
        List<String> result = new ArrayList<>();  // liste plate

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
                // ajouter un séparateur de mot, par exemple une double espace
                result.add(""); // vide pour un espace de séparation
            }
        } catch (AlgorithmError e) {
            System.out.println("\u001B[31mErreur d'Algorithme : \u001B[0m" + e.getMessage());
        }

        // Join avec un espace simple (ou double pour séparation mots)
        return String.join(" ", result).trim();
    }

    @Override
    public String reverseConversion(String user_input_hex) {
        String[] hexCodes = user_input_hex.trim().split("\\s+");
        List<String> decodedChars = new ArrayList<>();
        try {
            for (String hexCode : hexCodes) {
                if (hexCode.isEmpty()) continue; // ignorer séparateurs vides
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
                decodedChars.add(letter);
            }
        } catch (AlgorithmError e) {
            System.out.println("\u001B[31mErreur d'Algorithme : \u001B[0m" + e.getMessage());
        }
        return String.join(" ", decodedChars);
    }

}
