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
            List<List<Integer>> int_list_original = new ArrayList<>();
            List<List<String>> str_list_original = new ArrayList<>();

            List<List<Integer>> int_list_encrypted = new ArrayList<>();
            List<List<String>> str_list_encrypted = new ArrayList<>();

            List<List<Integer>> int_list_decrypted = new ArrayList<>();
            List<List<String>> str_list_decrypted = new ArrayList<>();

            int_list_original = decimal_converter.conversion(AsciiUtils.parseStringIntoStringList(clean_input.getCleanInput("VAS Y JOLYYYNE")));
            String user_input_int = AsciiUtils.concatenateFromInt(int_list_original);

            int_list_encrypted = caesar_cipher.caesarEncrypt(int_list_original, 2);
            str_list_encrypted = decimal_converter.reverseConversion(int_list_encrypted);
            String str_int_encrypted = AsciiUtils.concatenateFromInt(int_list_encrypted);
            String encrypted_string = AsciiUtils.concatenateFromString(str_list_encrypted);

            int_list_decrypted = caesar_cipher.caesarEncrypt(int_list_encrypted);
            str_list_decrypted = decimal_converter.reverseConversion(int_list_decrypted);
            String str_int_decrypted = AsciiUtils.concatenateFromInt(int_list_decrypted);
            String decrypted_string = AsciiUtils.concatenateFromString(str_list_decrypted);

            System.out.println("Entrée utilisateur (num): " + user_input_int);
            System.out.println("Entrée encryptée (char) : " + encrypted_string);
            System.out.println("Entrée encryptée (num)  : " + str_int_encrypted);
            System.out.println("Entrée décryptée (char) : " + decrypted_string);
            System.out.println("Entrée décryptée (num)  : " + str_int_decrypted);

        } catch (UserError e) {
            System.out.println("\u001B[36mErreur utilisateur : \u001B[0m " + e.getMessage());
        } catch (AlgorithmError e) {
            System.out.println("\u001B[31mErreur d'Algorihtme : \u001B[0m" + e.getMessage());
        }
    }
}