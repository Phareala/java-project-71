package hexlet.code.formatter;

import java.util.List;
import java.util.Map;

public class Stylish {
    public static String format(List<Map<String, Object>> differ) {
        StringBuilder result = new StringBuilder("{");
        for (Map<String, Object> element : differ) {
            var key = element.get("key");
            var oldValue = element.get("oldValue");
            var newValue = element.get("newValue");
            switch (String.valueOf(element.get("status"))) {
                case "removable" -> result.append(String.format("\n  - %s: %s", key, oldValue));
                case "added" -> result.append(String.format("\n  + %s: %s", key, newValue));
                case "unaltered" -> result.append(String.format("\n    %s: %s", key, oldValue));
                case "changeable" -> {
                    result.append(String.format("\n  - %s: %s", key, oldValue));
                    result.append(String.format("\n  + %s: %s", key, newValue));
                }
                default -> throw new IllegalStateException("Unexpected value: " + element.get("status"));
            }
        }
        result.append("\n}");
        return result.toString().trim();
    }
}
