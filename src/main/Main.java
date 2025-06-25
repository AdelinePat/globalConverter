package main;
import ascii.AsciiUtils;
import ascii.CleanInput;
import converters.*;
import custom_exceptions.AlgorithmError;
import custom_exceptions.UserError;
import caesar.caesarCipher;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        IConverter binary_converter = new BinaryConverter();
        IConverter octal_converter = new OctalConverter();
        IConverter hexa_converter  = new HexaConverter();
        IConverter decimal_converter = new DecimalConverter();
        CleanInput clean_input = new CleanInput();

        try {
            List<List<Integer>> user_input_list_int = new ArrayList<>();
            List<List<String>> user_input_list_str = new ArrayList<>();

            user_input_list_int = decimal_converter.conversion(AsciiUtils.parseStringIntoStringList(clean_input.getCleanInput("123!")));
            String user_input_int = AsciiUtils.concatenateFromInt(user_input_list_int);

            user_input_list_str = decimal_converter.reverseConversion(user_input_list_int);
            String user_input_str = AsciiUtils.concatenateFromString(user_input_list_str);

            System.out.println("Entrée utilisateur : " + user_input_int);
            System.out.println("Entrée utilisateur : " + user_input_str);

        } catch (UserError e) {
            System.out.println("\u001B[36mErreur utilisateur : \u001B[0m " + e.getMessage());
        } catch (AlgorithmError e) {
            System.out.println("\u001B[31mErreur d'Algorihtme : \u001B[0m" + e.getMessage());
        }
    }
}