    package ascii;
    import java.io.InputStream;
    import java.io.InputStreamReader;
    import java.util.ArrayList;
    import java.util.List;
    import java.util.Map;
    import com.google.gson.Gson;
    import com.google.gson.reflect.TypeToken;
    import custom_exceptions.AlgorithmError;

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
//            System.out.println("ASCII Table loaded:" + ascii_map);
        }

        public List<List<Integer>> parseStringIntoInt(String user_input) {
            List<List<Integer>> result = new ArrayList<>();
            String[] words = user_input.split(" ");

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
//                System.out.println(word + " ");
            }
            return result;
        }
        public List<String> fromIntToString(List<List<Integer>> user_input_int) {
            List<String> result = new ArrayList<>();
            try {
                for (List<Integer> word : user_input_int) {
//            System.out.println(word);
                    StringBuilder ascii_string = new StringBuilder();
                    for (Integer character : word) {
                        String letter = this.getCharacterByAsciiValue(character);
                        System.out.print(letter);
//                        Test exception AlgorithmError
//                        String letter_test = this.getCharacterByAsciiValue(156);
//                        System.out.print(letter_test);
                    }
                    System.out.print(" ");
                }
            } catch (AlgorithmError e) {
                System.out.println("\u001B[31mErreur d'Algorithme : \u001B[0m" + e.getMessage());
            }


            // debug
            System.out.println();
            for (List<Integer> word : user_input_int) {
                for (Integer character : word) {
                    System.out.print(character + " ");
                }
                System.out.print(" ");
            }
            return result;
        }

        private String getCharacterByAsciiValue(Integer ascii_value) throws AlgorithmError {
            boolean isValueFound = false;
            for (Map.Entry<String, Integer> entry : ascii_map.entrySet()) {
                if (entry.getValue().equals(ascii_value)) {
                    isValueFound = true;
                    return entry.getKey();
                }
            }
            if (!isValueFound) {
                throw new AlgorithmError("Attention, la valeur ASCII n'a pas de clé" +
                        "correspondante dans le ascii_table.json.");
            }
            return ""; // should find a way not to have a return here ???
        }

    }
