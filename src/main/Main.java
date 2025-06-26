package main;
import ascii.AsciiUtils;
import ascii.Parsing;
import ascii.CleanInput;
import caesar.CaesarCipher;
import converters.*;
import custom_exceptions.AlgorithmError;
import custom_exceptions.UserError;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        IConverter binary_converter = new BinaryConverter();
        IConverter octal_converter = new OctalConverter();
        IConverter hexa_converter  = new HexaConverter();
        IConverter decimal_converter = new DecimalConverter();
        CleanInput clean_input = new CleanInput();
        CaesarCipher caesar_cipher = new CaesarCipher();

        try {
            String original_user_input = clean_input.getCleanInput("Salutationa bonjour");

            // Test Decimal
            String user_input_int = decimal_converter.conversion(original_user_input);
            System.out.println("Entrée input d'entrée (num)      : " + user_input_int);

            // Test Caesar cipher
//            String user_caesar = caesar_cipher.caesarEncrypt(user_input_int, 3);
//            String user_caesar_reversed = caesar_cipher.caesarEncrypt(user_caesar);
//            System.out.println("Entrée après césar (clé de 3)    : " + user_caesar);
//            System.out.println("Entrée après césar inverse (num) : " + user_caesar_reversed);

            // Test Decimal after caesar cipher
//            String user_readable_caesar = decimal_converter.reverseConversion(user_caesar);
//            System.out.println("Entrée après césar remis en int  : " + user_readable_caesar);

//             Test conversion Hexa
            String user_input_hex = hexa_converter.conversion(original_user_input);
            String user_input_hex_reverse = hexa_converter.reverseConversion(user_input_hex);
            System.out.println("Conversion Hexa                  : " + user_input_hex);
            System.out.println("Conversion Hexa reverse          : " + user_input_hex_reverse);

            // Test Octal
            String user_input_octal = octal_converter.conversion(original_user_input);
            String user_octal_to_int = octal_converter.reverseConversion(user_input_octal);
            System.out.println("Entrée input octal (num)         : " + user_input_octal);
            System.out.println("Entrée octal to int (num)        : " + user_octal_to_int);

            // Test Binary
            String user_input_bin = binary_converter.conversion(original_user_input);
            String user_bin_to_int = binary_converter.reverseConversion(user_input_bin);
            System.out.println("Entrée int > bin (num)           : " + user_input_bin);
            System.out.println("Entrée bin > int (num)           : " + user_bin_to_int);
        }
        catch (UserError e) {
            System.out.println("\u001B[36mErreur utilisateur : \u001B[0m " + e.getMessage());
        }
        catch (AlgorithmError e) {
            System.out.println("\u001B[31mErreur d'Algorihtme : \u001B[0m" + e.getMessage());
        }
    }
}