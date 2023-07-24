package hexlet.code;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest {
    private static String jsonExpected;

    @BeforeAll
    static void prepareExpected() throws Exception {
        String expectedJsonPath = "src/test/resources/fixtures/JsonExpected.txt";
        jsonExpected = getExpectedData(expectedJsonPath);
    }

    public static String getExpectedData(String filePath) throws Exception {
        Path path = Paths.get(filePath).toAbsolutePath().normalize();
        if (Files.notExists(path) || Files.isDirectory(path)) {
            throw new Exception("wrong file path");
        }
        return  Files.readString(path);
    }

    @Test
    void testJson() throws Exception {
        var path1 = Parsing.getJsonString("src/test/resources/fixtures/file1.json");
        var path2 = Parsing.getJsonString("src/test/resources/fixtures/file2.json");
        String result = Differ.buildDiff(path1, path2);
        assertThat(result).isEqualTo(jsonExpected);
    }
}
