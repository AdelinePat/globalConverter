package converters;
import java.util.List;

public interface IConverter {
    public List<List<Integer>> conversion(List<List<Integer>> parsed_user_string);
    public String reverseConversion(List<List<Integer>> convertedInput);
    public String concatenateString(List<List<Integer>> convertedInput);
    public List<List<Integer>> parseStringIntoInt(String user_input);
}
