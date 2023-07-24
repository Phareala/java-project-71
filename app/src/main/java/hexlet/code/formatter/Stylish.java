package hexlet.code.formatter;

import java.util.List;
import java.util.Map;

public class Stylish {
    public static String format(List<Map<String, List<Object>>> differ) {
        StringBuilder result = new StringBuilder("{");
        for (Map<String, List<Object>> block : differ) {
            for (Map.Entry<String, List<Object>> element : block.entrySet()) {
                var key = element.getValue().get(0);
                var value = element.getValue();
                switch (element.getKey()) {
                    case "removable" -> result.append(String.format("\n - %s: %s", key, value.get(1)));
                    case "added" -> result.append(String.format("\n + %s: %s", key, value.get(1)));
                    case "unaltered" -> result.append(String.format("\n   %s: %s", key, value.get(1)));
                    case "changeable" -> {
                        result.append(String.format("\n - %s: %s", key, value.get(1)));
                        result.append(String.format("\n + %s: %s", key, value.get(2)));
                    }
                }
            }
        }
        result.append("\n}");
        return result.toString().trim();
    }
}
