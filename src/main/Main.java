package main;
import user_interface.MenuView;
import user_interface.MenuController;
import custom_exceptions.AlgorithmError;
import custom_exceptions.UserError;

public class Main {
    public static void main(String[] args) {
        MenuController controller = new MenuController();
        MenuView.displayProjectTitle();
        String user_choice = new String();
        do {
            try {
                MenuView.displayFirstInstruction();
                controller.getCleanInput();
                if (controller.isQuitCommand()) {
                    user_choice = controller.original_input;
                } else {
                    user_choice = controller.mainMenu();
                }
            } catch (UserError e) {
                System.out.println("\u001B[36mErreur utilisateur : \u001B[0m " + e.getMessage());
            } catch (AlgorithmError e) {
                System.out.println("\u001B[31mErreur d'Algorihtme : \u001B[0m" + e.getMessage());
            }
        } while (!user_choice.equals("quit") && !user_choice.equals("-q"));
    }
}