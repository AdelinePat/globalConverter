package user_interface;

import custom_exceptions.UserError;

public class MenuView {
    static public void displayProjectTitle() {
        System.out.println("\u001B[3J\u001B[1;1H\u001B[0J-- Bienvenue sur le GlobalConverter --");
    }

    static public void displayFirstInstruction() {
        System.out.println("Entrez une chaîne de caractère à traduire (a-Z, 0-9 uniquement)\n");
    }
    static public void displayMainMenu() {
        System.out.println("\nChoisissez une option :" +
                "\n1. Transformer du texte dans une base numérique" +
                "\n2. Chiffrer du texte" +
                "\n3. Quitter");
    }

    static public void displayMenuNumericBase() {
        System.out.println("\nChoisissez une option :" +
                "\nhexadecimal ou -h" +
                "\noctal ou -o" +
                "\ndecimal ou -d" +
                "\nbinary ou -b" +
                "\nchiffrement ou -c" +
                "\nquitter ou -q");
    }
    public static void subMenuChangeNumericBase() {
        System.out.println("\n1. Retranscrire les chiffres en lettre" +
                "\n2. Revenir au menu principal");
    }

    public static void displayMenuCaesarCipher() {
        System.out.println("\nChoisissez une clé de chiffrement : ");
    }

    public static void subMenuCaesarCipher() {
        System.out.println("\n1. Chiffrement inverse" +
                "\n2. Revenir au menu principal");
    }
}
