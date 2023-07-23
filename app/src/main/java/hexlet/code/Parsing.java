package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Parsing {

    public static Map<String, Object> getJsonString(String pathFile) throws IOException {
        String filePath = pathFile;
        Path path = Paths.get(filePath).toAbsolutePath().normalize();
        Map<String, Object> result =
                new ObjectMapper().readValue(path.toFile(), HashMap.class);
        return result;
    }

}
