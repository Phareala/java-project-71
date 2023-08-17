package hexlet.code;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class Parsing {

    public static Map<String, Object> parser(String pathFile, String fileFormat) throws IOException {
        Path path = Paths.get(pathFile).toAbsolutePath().normalize();
        return switch (fileFormat) {
            case "json" -> Differ.jsonMap(path);
            case "yml", "yaml" -> Differ.ymlMap(path);

            default -> throw new IllegalStateException("Unexpected extension: " + fileFormat);
        };
    }

}
