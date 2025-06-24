package main;
import ascii.AsciiConverter;
import ascii.CleanInput;
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
        AsciiConverter ascii_converter = new AsciiConverter();
        CleanInput clean_input = new CleanInput();

        clean_input.getCleanInput("Salut les gens ca va bien ou quoi");

        List<List<Integer>> ras_le_bol = new ArrayList<>();
        List<String> jenaimarre = new ArrayList<>();
        ras_le_bol = ascii_converter.parseStringIntoInt(clean_input.clean_input);
        jenaimarre = ascii_converter.fromIntToString(ras_le_bol);

    }
}