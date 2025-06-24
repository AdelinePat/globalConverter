package main;
import ascii.AsciiConverter;
import ascii.CleanInput;
import converters.HexaConverter;
import converters.IConverter;
import converters.BinaryConverter;
import converters.OctalConverter;
import custom_exceptions.UserError;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        IConverter binary_converter = new BinaryConverter();
        IConverter octal_converter = new OctalConverter();
        IConverter hexa_converter  = new HexaConverter();
        AsciiConverter ascii_converter = new AsciiConverter();
        CleanInput clean_input = new CleanInput();

        try {
            clean_input.getCleanInput("Si seulement les RH voulaient bien signer les contrats plus vite");

            List<List<Integer>> ras_le_bol = new ArrayList<>();
            List<String> jenaimarre = new ArrayList<>();
            ras_le_bol = ascii_converter.parseStringIntoInt(clean_input.clean_input);
            jenaimarre = ascii_converter.fromIntToString(ras_le_bol);
        } catch (UserError e) {
            System.out.println("\u001B[36mErreur utilisateur : \u001B[0m" + e.getMessage());
        }


    }
}