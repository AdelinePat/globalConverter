package converters;
import custom_exceptions.AlgorithmError;

import java.util.List;

public interface IConverter {
    public String conversion(String input_user) throws AlgorithmError;
    public String  reverseConversion(String user_input_int);
}
