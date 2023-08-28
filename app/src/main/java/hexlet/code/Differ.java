package hexlet.code;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import static hexlet.code.Builder.buildDiff;

public class Differ {

    public static String generate(String firstFilePath, String secondFilePath, String format) throws Exception {

        Map<String, Object> firstFile = Parser.parser(firstFilePath, getExtension(firstFilePath));
        Map<String, Object> secondFile = Parser.parser(secondFilePath, getExtension(secondFilePath));
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

}
