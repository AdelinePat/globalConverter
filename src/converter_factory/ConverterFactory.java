package converter_factory;

import converters.*;
import custom_exceptions.UserError;

public class ConverterFactory {
    static public IConverter createConverter(String choice) throws UserError{
        switch (choice) {
            case "hexadecimal" :
            case "-h" :
                return new HexaConverter();
            case "octal" :
            case "-o" :
                return new OctalConverter();
            case "decimal" :
            case "-d" :
                return new DecimalConverter();
            case "binary" :
            case "-b" :
                return new BinaryConverter();
            default:
                throw new UserError("La commande n'a pas été reconnue \u001B[33mveuillez renseigner exactement" +
                        "une des options sitée ci-dessus \u001B[0m");
        }
    }
}
