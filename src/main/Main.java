package main;
import converters.HexaConverter;
import converters.IConverter;
import converters.BinaryConverter;
import converters.OctalConverter;

public class Main {
    public static void main(String[] args) {
        IConverter binary_converter = new BinaryConverter();
        IConverter octal_converter = new OctalConverter();
        IConverter hexa_converter  = new HexaConverter();
        System.out.println("J'en ai ras le bol de IntelliJ qui est vraiment trop CON");
    }
}