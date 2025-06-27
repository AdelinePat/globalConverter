package user_interface;

import java.util.Scanner;

public class UserInterfaceView {

    public void printInputMenu() {
        System.out.println("\033[3J\033[1;0H\033[0J-- Bienvenue sur le GlobalConverter --");
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
        System.out.println("\033[3J\033[1;0H\033[0JTexte brut :");
        System.out.println(initial_input);
        System.out.println("\nConversion précédente :");
        System.out.println(previous_conversion);
        System.out.println("\nRésultat de la convertion :");
        System.out.println(final_conversion);
    }

    public void printConversions(String initial_input, String final_conversion) {
        System.out.println("\033[3J\033[1;0H\033[0JTexte brut :");
        System.out.println(initial_input);
        System.out.println("Résultat de la convertion :");
        System.out.println(final_conversion);
    }

    public void printSelectionMenu() {
        System.out.println("\n\nChoisissez une option :" +
                "\n1. Convertir en code ASCII" +
                "\n2. Convertir en binaire" +
                "\n3. Convertir en octal" +
                "\n4. Convertir en hexadécimal" +
                "\n5. Crypter en code César");
    }

    public void printCaesarEncrypting() {
        System.out.println("\nSélectionner un degré d'encryptage : ");
    }


}
