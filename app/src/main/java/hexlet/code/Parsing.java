package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Parsing {

    public static Map<String, Object> parser(String pathFile, String fileFormat) throws IOException {
        Path path = Paths.get(pathFile).toAbsolutePath().normalize();
        return switch (fileFormat) {
            case "json" -> new ObjectMapper().readValue(path.toFile(), HashMap.class);
            case "yml", "yaml" -> new YAMLMapper().readValue(path.toFile(), HashMap.class);

            default -> throw new IllegalStateException("Unexpected format: " + fileFormat);
        };
    }

}
