package hexlet.code.formatter;

import java.util.List;
import java.util.Map;

public class Plain {
    public static String format(List<Map<String, Object>> differ) {
        StringBuilder result = new StringBuilder();
        for (Map<String, Object> element : differ) {
            var key = element.get("key");
            var oldValue = element.get("oldValue");
            var newValue = element.get("newValue");
            switch (String.valueOf(element.get("status"))) {
                case "unaltered" -> {
                }
                case "removable" -> result.append(String.format("\nProperty %s was removed",
                    printObject(key)
                ));
                case "added" -> result.append(String.format("\nProperty %s was added with value: %s",
                    printObject(key),
                    printObject(newValue)
                ));
                case "changeable" -> result.append("\nProperty ").append(printObject(key))
                    .append(" was updated. From ").append(printObject(oldValue))
                    .append(" to ").append(printObject(newValue)
                );
                default -> throw new IllegalStateException("Unexpected value: " + key);
            }
        }
        return result.toString().trim();
    }

    private static String printObject(Object value) {
        if (value instanceof String) {
            return "'" + value + "'";
        }

        if (value instanceof List || value instanceof Map) {
            return "[complex value]";
        }

        return String.valueOf(value);
    }
}
