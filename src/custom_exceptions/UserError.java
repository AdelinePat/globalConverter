package custom_exceptions;

public class UserError extends Exception {
    public UserError(String message) {
        super(message);
    }
}
