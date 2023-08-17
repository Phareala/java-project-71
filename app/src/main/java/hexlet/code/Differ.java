package hexlet.code;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static hexlet.code.Builder.buildDiff;

public class Differ {

    public static String generate(String firstFilePath, String secondFilePath, String format) throws Exception {

        Map<String, Object> firstFile = Parsing.parser(firstFilePath, getExtension(firstFilePath));
        Map<String, Object> secondFile = Parsing.parser(secondFilePath, getExtension(secondFilePath));
        List<Map<String, List<Object>>> diffList = new ArrayList<>(buildDiff(firstFile, secondFile));
        return Formatter.format(diffList, format);
    }

    public static String generate(String firstFilePath, String secondFilePath) throws Exception {
        return generate(firstFilePath, secondFilePath, "stylish");
    }

    private static String getExtension(String filePath) {
        int index = filePath.lastIndexOf('.');
        return index > 0 ? filePath.substring(index + 1) : "";
    }

    public static HashMap jsonMap(Path path) throws IOException {
        return new ObjectMapper().readValue(path.toFile(), HashMap.class);
    }

    public static HashMap ymlMap(Path path) throws IOException {
        return new YAMLMapper().readValue(path.toFile(), HashMap.class);
    }

}
