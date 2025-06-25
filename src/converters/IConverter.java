package converters;
import custom_exceptions.AlgorithmError;

import java.util.List;

public interface IConverter {
    public List<List<Integer>> conversion(List<List<String>> parsed_user_string) throws AlgorithmError;
    public List<List<String>>  reverseConversion(List<List<Integer>> convertedInput);
}
