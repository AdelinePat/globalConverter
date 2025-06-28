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
            }
            catch (AlgorithmError e) {
                System.out.println("\u001B[31mErreur d'Algorihtme : \u001B[0m" + e.getMessage());
            }
        } while (!user_choice.equals("quitter") && !user_choice.equals("-q"));

    }
}