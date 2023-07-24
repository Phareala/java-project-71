package hexlet.code;

import hexlet.code.formatter.Plain;
import hexlet.code.formatter.Stylish;

import java.util.List;
import java.util.Map;

public class Formatter {
    public static String format(List<Map<String, List<Object>>> diffList, String format) {

        return switch (format) {
            case "stylish" -> Stylish.format(diffList);
            case "plain" -> Plain.format(diffList);
            default -> throw new IllegalStateException("Unexpected value: " + format);
        };
    }
}
