package user_interface;

import caesar.CaesarCipher;
import converter_factory.ConverterFactory;
import converters.IConverter;
import custom_exceptions.AlgorithmError;
import custom_exceptions.UserError;
import utils.CleanInput;

import java.util.Scanner;

public class MenuController {
    public String original_input = new String();
    private String converted_input = new String();

    public void getCleanInput() throws UserError {
        this.original_input = CleanInput.getCleanInput(this.handleUserInput());
    }

    public String handleUserInput() {
        Scanner user_input_scanner = new Scanner(System.in);
        return user_input_scanner.nextLine();
    }

    public boolean isQuitCommand() {
        return this.original_input.equals("quit") || this.original_input.equals("-q");
    }

    public int handleUserIntChoice() {
        Scanner user_input_scanner = new Scanner(System.in);
        return user_input_scanner.nextInt();
    }
    public String mainMenu() throws AlgorithmError, UserError {
        MenuView.displayMenuNumericBase();
        String user_choice = this.handleUserInput();
        if (user_choice.equals("encryption") || user_choice.equals("-e")) {
            this.caesarCipher();
        } else if (user_choice.equals("quit") || user_choice.equals("-q")) {
            return user_choice;
        }
        else {
            this.changeNumericBase(user_choice);
        }
        return user_choice;
    }
    private void changeNumericBase(String user_choice) throws AlgorithmError, UserError {
        IConverter converter = ConverterFactory.createConverter(user_choice);
        this.converted_input = converter.conversion(original_input);
        System.out.println("\u001B[35mConversion dans la base voulue : \u001B[0m " + this.converted_input);
        MenuView.subMenuChangeNumericBase();
        int choice = this.handleUserIntChoice();
        switch (choice) {
            case 1:
                String reverse_converted_input = converter.reverseConversion(this.converted_input);
                System.out.println("\u001B[35mConversion inverse             : \u001B[0m" + reverse_converted_input);
                break;
            case 2: return;
            default : throw new UserError("La commande n'a pas été reconnue \u001B[33mveuillez renseigner exactement " +
                    "une des options sitée ci-dessus \u001B[0m");
        }
    }

    private void caesarCipher() throws AlgorithmError, UserError {
        MenuView.displayMenuCaesarCipher();
        int cipher_key = this.handleUserIntChoice();
        CaesarCipher cipher = new CaesarCipher();
        this.converted_input = cipher.caesarEncrypt(original_input, cipher_key);
        System.out.println("\u001B[35mChaîne chiffrée : \u001B[0m " + this.converted_input);

        MenuView.subMenuCaesarCipher();
        int choice = this.handleUserIntChoice();
        switch (choice) {
            case 1: System.out.println("\u001B[35mChiffrement inverse (chaîne d'origine) : \u001B[0m" + cipher.caesarEncrypt(this.converted_input));
                break;
            case 2: return;
            default : throw new UserError("La commande n'a pas été reconnue \u001B[33mveuillez renseigner exactement " +
                    "une des options sitée ci-dessus \u001B[0m");
        }
    }

}
