package user_interface;

import custom_exceptions.UserError;

public class Menu {
    static public void displayFirstInstruction() {
        System.out.println("\u001B[3J\u001B[1;0H\u001B[0J-- Bienvenue sur le GlobalConverter --");
        System.out.println("Entrez une chaîne de caractère à traduire (a-Z, 0-9 uniquement)\n");
    }
    static public void displayMainMenu() {
        System.out.println("\n\nChoisissez une option :" +
                "\n1. Transformer du texte dans une base numérique" +
                "\n2. Chiffrer du texte" +
                "\n3. Quitter");
    }

    static public void displayMenu() {
        System.out.println("\n\nChoisissez une option :" +
                "\nhexadecimal ou -h" +
                "\noctal ou -o" +
                "\ndecimal ou -d" +
                "\nbinary ou -b" +
                "\nchiffrement ou -c");
    }
    public static void subMenuChangeNumericBase() {
        System.out.println("\n1. Retranscrire les chiffres en lettre" +
                "\n2. Revenir au menu principal");
    }

    static public void redirectMainMenu(int choice) throws UserError {
        switch (choice) {
            case 1: displayFirstInstruction();
            case 2: return;
            case 3: return;
            default : throw new UserError("La commande n'a pas été reconnue \u001B[33mveuillez renseigner exactement" +
                        "une des options sitée ci-dessus \u001B[0m");
        }
    }

}
