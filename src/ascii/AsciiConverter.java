    package ascii;
    import java.io.InputStream;
    import java.io.InputStreamReader;
    import java.util.ArrayList;
    import java.util.List;
    import java.util.Map;
    import com.google.gson.Gson;
    import com.google.gson.reflect.TypeToken;

    public class AsciiConverter {
        public Map<String, Integer> ascii_map;
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

        public List<List<Integer>> parseStringIntoInt(String user_input) {
            List<List<Integer>> result = new ArrayList<>();
            String[] words = user_input.trim().split(" ");

            for (String word : words) {
                List<Integer> ascii_values = new ArrayList<>();
                for (char c : word.toCharArray()) {
                    String character = String.valueOf(c);
//                    System.out.println("valueof(c) :" + character + " ");
                    Integer ascii_code = ascii_map.get(character);
//                    System.out.println("ascii_map.get(character) :" + ascii_code + " ");

                    if (ascii_code != null) {
                        ascii_values.add(ascii_code);
                    } else {
                        System.out.println("ascii_code is null or not found inside ascii_map");
                    }
                }
                result.add(ascii_values);
                System.out.println(word + "\n");
            }
            return result;
        }
    }
