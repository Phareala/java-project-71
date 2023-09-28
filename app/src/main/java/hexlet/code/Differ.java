package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import static hexlet.code.Builder.buildDiff;

public class Differ {

    public static String generate(String firstFilePath, String secondFilePath, String format) throws Exception {

        String firstData = getData(firstFilePath);
        String secondData = getData(secondFilePath);
        Map<String, Object> firstFile = Parser.parser(firstData, getExtension(firstFilePath));
        Map<String, Object> secondFile = Parser.parser(secondData, getExtension(secondFilePath));
        List<Map<String, Object>> diffList = new ArrayList<>(buildDiff(firstFile, secondFile));
        return Formatter.format(diffList, format);
    }

    public static String generate(String firstFilePath, String secondFilePath) throws Exception {
        return generate(firstFilePath, secondFilePath, "stylish");
    }

    private static String getExtension(String filePath) {
        int index = filePath.lastIndexOf('.');
        return index > 0 ? filePath.substring(index + 1) : "";
    }

    public static String getData(String filePath) throws Exception {
        Path path = Paths.get(filePath).toAbsolutePath().normalize();
        if (Files.notExists(path) || Files.isDirectory(path)) {
            throw new Exception("wrong file type or path");
        }
        return Files.readString(path);
    }

}
