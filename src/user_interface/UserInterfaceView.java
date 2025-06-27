package user_interface;

import java.util.Scanner;

public class UserInterfaceView {

    public void printInputMenu() {
        System.out.println("\u001B[3J\u001B[1;0H\u001B[0J-- Bienvenue sur le GlobalConverter --");
        System.out.println("Entrez une chaîne de caractère à traduire (a-Z, 0-9 uniquement)\n");
    }

    public String handleUserInput() {
        Scanner user_input_scanner = new Scanner(System.in);
        return user_input_scanner.nextLine();
    }

    public int handleUserIntChoice() {
        Scanner user_input_scanner = new Scanner(System.in);
        return user_input_scanner.nextInt();
    }

    public void printConversions(String initial_input, String previous_conversion, String final_conversion) {
        System.out.println("\u001B[3J\u001B[1;0H\u001B[0JTexte brut :");
        System.out.println(initial_input);
        if (previous_conversion != "") {
            System.out.println("\nConversion précédente :");
            System.out.println(previous_conversion);
        }
        if (final_conversion != "") {
            System.out.println("\nRésultat de la convertion :");
            System.out.println(final_conversion);
        }
    }

    public void printSelectionMenu() {
        System.out.println("\n\nChoisissez une option :" +
                "\n1. Convertir en code ASCII décimal" +
                "\n2. Convertir en binaire" +
                "\n3. Convertir en octal" +
                "\n4. Convertir en hexadécimal" +
                "\n5. Crypter en code César" +
                "\n6. Quitter le programme");
    }

    public void printCaesarEncrypting() {
        System.out.println("\nSélectionner un degré d'encryptage : ");
    }


}
