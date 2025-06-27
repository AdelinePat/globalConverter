package main;
import ascii.CleanInput;
import custom_exceptions.AlgorithmError;
import custom_exceptions.UserError;
import user_interface.*;

public class InteractiveMain {
    static UserInterfaceControl current_user;
    static UserInterfaceView user_interface_view;

    static String initial_input;
    static String ascii_string;
    static String previous_conversion;
    static String conversion_result;

    public static void main(String[] args) {
        startProgram();


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

    private static int runProgram(String initial_input) {
        while (true) {
            break;
        }
        return 0;
    }
}
