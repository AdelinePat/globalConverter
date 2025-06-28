package utils;
import custom_exceptions.UserError;
import user_interface.MenuController;

public class CleanInput {
//    public static String clean_input;
    public CleanInput() {
    }
    public static boolean isValidInput(String raw_user_input) {
        return raw_user_input.matches(".*[^a-zA-Z0-9 ].*");
    }

    public static String getCleanInput(String raw_user_input) throws UserError {
            if (CleanInput.isValidInput(raw_user_input)) {
                throw new UserError("Des caractères non autorisés ont été utilisé. \u001B[33mveuillez utiliser uniquement des " +
                        "lettres (sans accent) et des chiffres.\u001B[0m");
            } else {
                raw_user_input = raw_user_input.trim();
                return raw_user_input;
            }
    }

    public static int stringToInt(String str) {
        int result = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
//            int digit = c - '0';
            Integer digit = AsciiUtils.ascii_map.get(String.valueOf(c)) - AsciiUtils.ascii_map.get("0");
            result = result * 10 + digit;
        }
        return result;
    }

}
