package hexlet.code.formatter;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class Plain {
    public static String format(List<Map<String, List<Object>>> differ) {
        StringBuilder result = new StringBuilder();
        for (Map<String, List<Object>> block : differ) {
            for (Map.Entry<String, List<Object>> element : block.entrySet()) {
                var key = element.getValue().get(0);
                var value = element.getValue();
                switch (element.getKey()) {
                    case "unaltered" -> {

                    }
                    case "removable" -> result.append(String.format("\nProperty %s was removed",
                            printObject(key)
                    ));
                    case "added" -> result.append(String.format("\nProperty %s was added with value: %s",
                            printObject(key),
                            printObject(value.get(1))
                    ));
                    case "changeable" -> result.append("\nProperty ").append(printObject(key))
                            .append(" was updated. From ").append(printObject(value.get(1)))
                            .append(" to ").append(printObject(value.get(2)
                    ));

                    default -> throw new IllegalStateException("Unexpected value: " + key);
                }
            }
        }
        return result.toString().trim();
    }

    private static String printObject(Object value) {
        String result;
        if (value instanceof String) {
            result = "'" + value + "'";
        } else if ((value instanceof Collection<?>)
                || (value instanceof Arrays)
                || (value instanceof Map<?, ?>)) {
            result = "[complex value]";
        } else {
            result = String.valueOf(value);
        }
        return result;
    }
}
