package main;
import user_interface.MenuView;
import user_interface.MenuController;
import utils.CleanInput;
import caesar.CaesarCipher;
import converters.*;
import custom_exceptions.AlgorithmError;
import custom_exceptions.UserError;

public class Main {
    public static void main(String[] args) {
        MenuView.displayProjectTitle();
        String user_choice = new String();
        do {
            try {
            MenuView.displayFirstInstruction();
            MenuController.original_input = CleanInput.getCleanInput(MenuController.handleUserInput());
            if (MenuController.original_input.equals("quitter") || MenuController.original_input.equals("-q")) {
                user_choice = MenuController.original_input;
            } else {
                user_choice = MenuController.mainMenu();
            }
            } catch (UserError e) {
                System.out.println("\u001B[36mErreur utilisateur : \u001B[0m " + e.getMessage());
                continue;
            }
            catch (AlgorithmError e) {
                System.out.println("\u001B[31mErreur d'Algorihtme : \u001B[0m" + e.getMessage());
                continue;
            }
        } while (!user_choice.equals("quitter") && !user_choice.equals("-q"));

    }



    public static void ex_main() {
        IConverter binary_converter = new BinaryConverter();
        IConverter octal_converter = new OctalConverter();
        IConverter hexa_converter  = new HexaConverter();
        IConverter decimal_converter = new DecimalConverter();
        CleanInput clean_input = new CleanInput();
        CaesarCipher caesar_cipher = new CaesarCipher();

        try {
            String original_user_input = clean_input.getCleanInput("Ca marche une fois sur deux");

            // Test Decimal
            String user_input_int = decimal_converter.conversion(original_user_input);
            String user_input_reverse_decimal = decimal_converter.reverseConversion(user_input_int);
            System.out.println("Original > decimal               : " + user_input_int);
            System.out.println("Decimal > string (original)      : " + user_input_reverse_decimal + "\n");

            // Test Caesar cipher
            String user_caesar = caesar_cipher.caesarEncrypt(original_user_input, 3);
            String user_caesar_reversed = caesar_cipher.caesarEncrypt(user_caesar);
            System.out.println("String > chiffré (+ clé)         : " + user_caesar);
            System.out.println("Chiffré > original_string (- clé): " + user_caesar_reversed + "\n");

            // Test Decimal after caesar cipher
//            String user_readable_caesar = decimal_converter.reverseConversion(user_caesar);
//            System.out.println("Int > decimal (après chiffrement): " + user_readable_caesar);
//            System.out.println("Déchiffrement                    : " +
//                    decimal_converter.reverseConversion(
//                            caesar_cipher.caesarEncrypt(
//                            decimal_converter.conversion(user_readable_caesar), -3))
//                    + "\n");

//             Test conversion Hexa
            String user_input_hex = hexa_converter.conversion(original_user_input);
            String user_input_hex_reverse = hexa_converter.reverseConversion(user_input_hex);
            System.out.println("Original > Hexadecimal           : " + user_input_hex);
            System.out.println("Hexadecimal > string (original)  : " + user_input_hex_reverse + "\n");

            // Test Octal
            String user_input_octal = octal_converter.conversion(original_user_input);
            String user_octal_to_int = octal_converter.reverseConversion(user_input_octal);
            System.out.println("Original > Octal                 : " + user_input_octal);
            System.out.println("Octal > string (original)        : " + user_octal_to_int + "\n");

            // Test Binary
            String user_input_bin = binary_converter.conversion(original_user_input);
            String user_bin_to_int = binary_converter.reverseConversion(user_input_bin);
            System.out.println("Original > binaire               : " + user_input_bin);
            System.out.println("Binaire > string (original)      : " + user_bin_to_int);
        }
        catch (UserError e) {
            System.out.println("\u001B[36mErreur utilisateur : \u001B[0m " + e.getMessage());
        }
        catch (AlgorithmError e) {
            System.out.println("\u001B[31mErreur d'Algorihtme : \u001B[0m" + e.getMessage());
        }
    }
}