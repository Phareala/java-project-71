package hexlet.code;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest {
    private static String stylishExpected;
    private static String plainExpected;

    @BeforeAll
    static void prepareExpected() throws Exception {

        String expectedStylishPath = "src/test/resources/stylishExpected.txt";
        String expectedPlainPath = "src/test/resources/plainExpected.txt";

        stylishExpected = getExpectedData(expectedStylishPath);
        plainExpected = getExpectedData(expectedPlainPath);
    }

    public static String getExpectedData(String filePath) throws Exception {
        Path path = Paths.get(filePath).toAbsolutePath().normalize();
        if (Files.notExists(path) || Files.isDirectory(path)) {
            throw new Exception("wrong file path");
        }
        return  Files.readString(path);
    }

    @Test
    void testJsonStylish() throws Exception {
        String path1 = "src/test/resources/file1.json";
        String path2 = "src/test/resources/file2.json";
        String result = Differ.genDiff(path1, path2, "stylish");
        assertThat(result).isEqualTo(stylishExpected);
    }

    @Test
    void testYamlStylish() throws Exception {
        String path1 = "src/test/resources/file1.yml";
        String path2 = "src/test/resources/file2.yml";
        String result = Differ.genDiff(path1, path2, "stylish");
        assertThat(result).isEqualTo(stylishExpected);
    }

    @Test
    void testJsonPlain() throws Exception {
        String path1 = "src/test/resources/file1.json";
        String path2 = "src/test/resources/file2.json";
        String result = Differ.genDiff(path1, path2, "plain");
        assertThat(result).isEqualTo(plainExpected);
    }

    @Test
    void testYamlPlain() throws Exception {
        String path1 = "src/test/resources/file1.yml";
        String path2 = "src/test/resources/file2.yml";
        String result = Differ.genDiff(path1, path2, "plain");
        assertThat(result).isEqualTo(plainExpected);
    }
}
