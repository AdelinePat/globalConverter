package main;
import ascii.AsciiUtils;
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
            String original_user_input = clean_input.getCleanInput("coucou les gens ");
            String user_input_int = decimal_converter.conversion(original_user_input);
            String user_input_bin =  binary_converter.conversion(user_input_int);
            String user_caesar = caesar_cipher.caesarEncrypt(user_input_int, 3);
            String user_caesar_reversed = caesar_cipher.caesarEncrypt(user_caesar);
            String user_readable_caesar = decimal_converter.reverseConversion(user_caesar);
            String user_input_string = decimal_converter.reverseConversion(user_caesar_reversed);

            System.out.println("Entrée input d'entrée (num)      : " + user_input_int);
            System.out.println("Entrée input bin (num)           : " + user_input_bin);
            System.out.println("Entrée après césar (num)         : " + user_caesar);
            System.out.println("Entrée après césar (num)         : " + user_readable_caesar);
            System.out.println("Entrée après césar inverse (num) : " + user_caesar_reversed);
            System.out.println("Entrée input de base (char)      : " + user_input_string);

        }
        catch (UserError e) {
            System.out.println("\u001B[36mErreur utilisateur : \u001B[0m " + e.getMessage());
        }
        catch (AlgorithmError e) {
            System.out.println("\u001B[31mErreur d'Algorihtme : \u001B[0m" + e.getMessage());
        }
    }
}