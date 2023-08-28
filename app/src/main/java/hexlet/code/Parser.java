package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Parser {

    public static HashMap jsonMap(Path path) throws IOException {
        return new ObjectMapper().readValue(path.toFile(), HashMap.class);
    }

    public static HashMap ymlMap(Path path) throws IOException {
        return new YAMLMapper().readValue(path.toFile(), HashMap.class);
    }

    public static Map<String, Object> parser(String pathFile, String fileFormat) throws IOException {
        Path path = Paths.get(pathFile).toAbsolutePath().normalize();
        return switch (fileFormat) {
            case "json" -> jsonMap(path);
            case "yml", "yaml" -> ymlMap(path);

            default -> throw new IllegalStateException("Unexpected extension: " + fileFormat);
        };
    }

}
