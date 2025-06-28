package user_interface;

import caesar.CaesarCipher;
import converter_factory.ConverterFactory;
import converters.IConverter;
import custom_exceptions.AlgorithmError;
import custom_exceptions.UserError;

import java.util.Scanner;

public class MenuController {
    public static String original_input = new String();
    public static String converted_input = new String();
    public static String reverse_converted_input = new String();

    public static String handleUserInput() {
        Scanner user_input_scanner = new Scanner(System.in);
        return user_input_scanner.nextLine();
    }

    public static int handleUserIntChoice() {
        Scanner user_input_scanner = new Scanner(System.in);
        return user_input_scanner.nextInt();
    }
    public static String mainMenu() throws AlgorithmError, UserError {
        MenuView.displayMenuNumericBase();
        String user_choice = MenuController.handleUserInput();
        if (user_choice.equals("chiffrement") || user_choice.equals("-c")) {
            MenuController.caesarCipher();
        } else if (user_choice.equals("quitter") || user_choice.equals("-q")) {
            return user_choice;
        }
        else {
            MenuController.changeNumericBase(user_choice);
        }
        return user_choice;
    }
    public static void changeNumericBase(String user_choice) throws AlgorithmError, UserError {
        IConverter converter = ConverterFactory.createConverter(user_choice);
        MenuController.converted_input = converter.conversion(original_input);
        System.out.println("\u001B[35mConversion dans la base voulue : \u001B[0m " + MenuController.converted_input);
        MenuController.reverse_converted_input = converter.reverseConversion(MenuController.converted_input);
        MenuView.subMenuChangeNumericBase();
        int choice = MenuController.handleUserIntChoice();
        switch (choice) {
            case 1: System.out.println("\u001B[35mConversion inverse             : \u001B[0m" + MenuController.reverse_converted_input);
            break;
            case 2: return;
            default : throw new UserError("La commande n'a pas été reconnue \u001B[33mveuillez renseigner exactement " +
                    "une des options sitée ci-dessus \u001B[0m");
        }
    }

    public static void caesarCipher() throws AlgorithmError, UserError {
        MenuView.displayMenuCaesarCipher();
        int cipher_key = MenuController.handleUserIntChoice();
        CaesarCipher cipher = new CaesarCipher();
        MenuController.converted_input = cipher.caesarEncrypt(original_input, cipher_key);
        System.out.println("\u001B[35mChaîne chiffrée : \u001B[0m " + MenuController.converted_input);

        MenuView.subMenuCaesarCipher();
        int choice = MenuController.handleUserIntChoice();
        switch (choice) {
            case 1: System.out.println("\u001B[35mChiffrement inverse (chaîne d'origine) : \u001B[0m" + cipher.caesarEncrypt(MenuController.converted_input));
                break;
            case 2: return;
            default : throw new UserError("La commande n'a pas été reconnue \u001B[33mveuillez renseigner exactement " +
                    "une des options sitée ci-dessus \u001B[0m");
        }
    }


}
