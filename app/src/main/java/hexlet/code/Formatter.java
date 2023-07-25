package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import hexlet.code.formatter.Json;
import hexlet.code.formatter.Plain;
import hexlet.code.formatter.Stylish;

import java.util.List;
import java.util.Map;

public class Formatter {
    public static String format(List<Map<String, List<Object>>> diffList, String format)
            throws JsonProcessingException {

        return switch (format) {
            case "stylish" -> Stylish.format(diffList);
            case "plain" -> Plain.format(diffList);
            case "json" -> Json.format(diffList);
            default -> throw new IllegalStateException("Unexpected value: " + format);
        };
    }
}
