package user_interface;

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

    public static void changeNumericBase() throws AlgorithmError, UserError {
        Menu.displayMenu();
        String user_choice = MenuController.handleUserInput();
        IConverter converter = ConverterFactory.createConverter(user_choice);
        MenuController.converted_input = converter.conversion(original_input);
        System.out.println("\u001B[35mConversion dans la base voulue : \u001B[0m " + MenuController.converted_input);
        MenuController.reverse_converted_input = converter.reverseConversion(MenuController.converted_input);
        Menu.subMenuChangeNumericBase();
        int choice = MenuController.handleUserIntChoice();
        switch (choice) {
            case 1: System.out.println("\u001B[35mConversion inverse             : \u001B[0m" + MenuController.reverse_converted_input);
            break;
            case 2: return;
            default : throw new UserError("La commande n'a pas été reconnue \u001B[33mveuillez renseigner exactement" +
                    "une des options sitée ci-dessus \u001B[0m");
        }
    }


}
