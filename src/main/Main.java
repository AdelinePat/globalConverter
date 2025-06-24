package main;
import ascii.AsciiConverter;
import converters.HexaConverter;
import converters.IConverter;
import converters.BinaryConverter;
import converters.OctalConverter;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        IConverter binary_converter = new BinaryConverter();
        IConverter octal_converter = new OctalConverter();
        IConverter hexa_converter  = new HexaConverter();
        System.out.println("J'en ai ras le bol de IntelliJ qui est vraiment trop CON");
        AsciiConverter ascii_converter = new AsciiConverter();

        List<List<Integer>> ras_le_bol = new ArrayList<>();
        ras_le_bol = ascii_converter.parseStringIntoInt("Coucou les gens");

        for (List<Integer> word : ras_le_bol) {
//            System.out.println(word);
            for (Integer character : word) {
                System.out.print(character + " ");
            }
            System.out.println();
        }

    }
}