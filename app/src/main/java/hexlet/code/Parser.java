package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.IOException;
import java.util.Map;

public class Parser {
    public static Map<String, Object> parser(String content, String fileFormat) throws IOException {
        return switch (fileFormat) {
            case "json" -> jsonMap(content);
            case "yml", "yaml" -> ymlMap(content);

            default -> throw new IllegalStateException("Unexpected extension: " + fileFormat);
        };
    }

    private static Map<String, Object> jsonMap(String content) throws IOException {
        return new ObjectMapper().readValue(content, new TypeReference<>() {
        });
    }

    private static Map<String, Object> ymlMap(String content) throws IOException {
        return new YAMLMapper().readValue(content, new TypeReference<>() {
        });
    }
}
