package main;
import utils.CleanInput;
import custom_exceptions.AlgorithmError;
import custom_exceptions.UserError;
import user_interface.*;

import java.util.InputMismatchException;

public class InteractiveMain {
    static UserInterfaceControl current_user;
    static UserInterfaceView user_interface_view;

    static String initial_input = "";
    static String ascii_string = "";
    static String previous_conversion = "";
    static String conversion_result = "";

    public static void main(String[] args) throws AlgorithmError {
        startProgram();
        System.out.println(runProgram());
    }

    private static void startProgram() {
        while(true) {
            current_user = new UserInterfaceControl();
            user_interface_view = new UserInterfaceView();
            CleanInput clean_input = new CleanInput();

            try {
                user_interface_view.printInputMenu();
                initial_input = user_interface_view.handleUserInput();
                initial_input = clean_input.getCleanInput(initial_input);
                ascii_string = current_user.convertUserChoice(1, initial_input);
                break;
            } catch (UserError e) {
                System.out.println("\u001B[36mErreur utilisateur : \u001B[0m " + e.getMessage());
            } catch (AlgorithmError e) {
                System.out.println("\u001B[31mErreur d'Algorihtme : \u001B[0m" + e.getMessage());
            }
        }
    }

    private static int runProgram() throws AlgorithmError {
        while (true) {
            int user_choice = 6;

            while (true) {
                try {
                    user_interface_view.printConversions(initial_input, previous_conversion, conversion_result);
                    user_interface_view.printSelectionMenu();
                    user_choice = user_interface_view.handleUserIntChoice();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("\u001B[36mErreur utilisateur : \u001B[0m Veuillez insérez uniquement un chiffre");
                }
            }

            switch (user_choice) {
                case 1 : conversion_result = ascii_string;
                    break;
                case 2 : case 3 : case 4 : conversion_result = current_user.convertUserChoice(user_choice, initial_input);
                    break;
                case 5 : ascii_string = conversion_result = launchCaesarEncrypt();
                initial_input = current_user.reverseConvert(1, conversion_result);
                 break;
                case 6 : {
                    return 0;
                }
                default : {
                    continue;
                }
            }
        }
    }

    private static String launchCaesarEncrypt() {
        while (true) {
            try {
                user_interface_view.printCaesarEncrypting();
                int caesar_offset = user_interface_view.handleUserIntChoice();
                return current_user.convertUserChoice(5, ascii_string, caesar_offset);

            } catch (InputMismatchException e) {
                System.out.println("\u001B[36mErreur utilisateur : \u001B[0m Veuillez insérez uniquement un chiffre");
            } catch (AlgorithmError e) {
                System.out.println("\u001B[31mErreur d'Algorihtme : \u001B[0m" + e.getMessage());
            }
        }
    }
}
