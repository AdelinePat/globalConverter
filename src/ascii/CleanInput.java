package ascii;
import custom_exceptions.UserError;

public class CleanInput {
    public String clean_input;
    public CleanInput() {
//        getCleanInput((input));
    }
    /* Implementation of regex, clean spaces at begining and
    end of the string, make sure the string doesn't contain anything more than alphanumeric character
    If any exception are thrown : please use UserError custom exception */
    private boolean isValidInput(String raw_user_input) {
        return raw_user_input.matches(".*[^a-zA-Z0-9 ].*");
    }

    public void getCleanInput(String raw_user_input) throws UserError {
            if (this.isValidInput(raw_user_input)) {
                throw new UserError("Des caractères non autorisés ont été utilisé. \u001B[33mveuillez utiliser uniquement des " +
                        "lettres (sans accent) et des chiffres.\u001B[0m");
            } else {
                raw_user_input = raw_user_input.trim();
                clean_input = raw_user_input;
            }

    }
}
