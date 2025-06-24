package ascii;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class AsciiConverter {
    private Map<String, Integer> ascii_map;
    public AsciiConverter() {
        loadAsciiTable();
    }
    private void loadAsciiTable() {

        InputStream inputStream = getClass().getResourceAsStream("/ascii_table.json");

        if (inputStream == null) {
            System.out.println("File not found! Please check the path.");
            return; // Exit or handle the error
        }
        InputStreamReader reader = new InputStreamReader(inputStream);
        Gson gson = new Gson();
        ascii_map = gson.fromJson(reader, new TypeToken<Map<String, Integer>>() {}.getType());
        System.out.println("ASCII Table loaded:" + ascii_map);
    }
}
