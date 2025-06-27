package main;
import ascii.CleanInput;
import custom_exceptions.AlgorithmError;
import custom_exceptions.UserError;
import user_interface.*;

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
            } catch (UserError | AlgorithmError e) {
                continue;
            }
        }
    }

    private static int runProgram() throws AlgorithmError {
        while (true) {
            user_interface_view.printConversions(initial_input, previous_conversion, conversion_result);
            user_interface_view.printSelectionMenu();
            int user_choice = user_interface_view.handleUserIntChoice();
            if (conversion_result != "") {
                previous_conversion = conversion_result;
            }
            if (user_choice == 1) {
                conversion_result = ascii_string;
            }
            else if (user_choice != 5) {
                conversion_result = current_user.convertUserChoice(user_choice, ascii_string);
            }
            else if (user_choice == 5) {
                user_interface_view.printCaesarEncrypting();
                int caesar_offset = user_interface_view.handleUserIntChoice();
                conversion_result = current_user.convertUserChoice(5, caesar_offset);
            }
            else {
                break;
            }
        }
        return 0;
    }
}
