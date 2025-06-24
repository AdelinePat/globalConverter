package custom_exceptions;

public class AlgorithmError extends Exception {
    public AlgorithmError(String message) {
        super(message);
    }
}