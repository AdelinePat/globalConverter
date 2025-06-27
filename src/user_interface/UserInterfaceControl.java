package user_interface;

import utils.CleanInput;
import caesar.CaesarCipher;
import converters.*;
import custom_exceptions.AlgorithmError;

public class UserInterfaceControl {

    private IConverter binary_converter;
    private IConverter octal_converter;
    private IConverter hexa_converter;
    private IConverter decimal_converter;
    private CleanInput clean_input;
    private CaesarCipher caesar_cipher;

    public UserInterfaceControl() {
        binary_converter = new BinaryConverter();
        octal_converter = new OctalConverter();
        hexa_converter  = new HexaConverter();
        decimal_converter = new DecimalConverter();
        clean_input = new CleanInput();
        caesar_cipher = new CaesarCipher();
    }

    public String convertUserChoice(int choice_index, String conversion_base) throws AlgorithmError {
        return switch (choice_index) {
            case 1 -> decimal_converter.conversion(conversion_base);
            case 2 -> binary_converter.conversion(conversion_base);
            case 3 -> octal_converter.conversion(conversion_base);
            case 4 -> hexa_converter.conversion(conversion_base);
            default -> conversion_base;
        };
    }

    public String reverseConvert(int choice_index, String conversion_base) throws AlgorithmError {
        return switch (choice_index) {
            case 1 -> decimal_converter.reverseConversion(conversion_base);
            case 2 -> binary_converter.reverseConversion(conversion_base);
            case 3 -> octal_converter.reverseConversion(conversion_base);
            case 4 -> hexa_converter.reverseConversion(conversion_base);
            default -> conversion_base;
        };
    }

    public String convertUserChoice(int choice_index, String ascii_string, int caesar_offset) throws AlgorithmError {
        return switch (choice_index) {
            case 5 -> caesar_cipher.caesarEncrypt(ascii_string, caesar_offset);
            default -> ascii_string;
        };
    }
}
