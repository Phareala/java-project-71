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
    private static String jsonExpected;

    String pathJson1 = "src/test/resources/file1.yml";
    String pathJson2 = "src/test/resources/file2.yml";
    String pathYaml1 = "src/test/resources/file1.yml";
    String pathYaml2 = "src/test/resources/file2.yml";



    @BeforeAll
    static void prepareExpected() throws Exception {
        String expectedStylishPath = "src/test/resources/stylishExpected.txt";
        String expectedPlainPath = "src/test/resources/plainExpected.txt";
        String expectedJsonPath = "src/test/resources/jsonExpected.txt";

        stylishExpected = getExpectedData(expectedStylishPath);
        plainExpected = getExpectedData(expectedPlainPath);
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
    void testJsonStylish() throws Exception {
        String result = Differ.genDiff(pathJson1, pathJson2, "stylish");
        assertThat(result).isEqualTo(stylishExpected);
    }

    @Test
    void testYamlStylish() throws Exception {
        String result = Differ.genDiff(pathYaml1, pathYaml2, "stylish");
        assertThat(result).isEqualTo(stylishExpected);
    }

    @Test
    void testJsonPlain() throws Exception {
        String result = Differ.genDiff(pathJson1, pathJson2, "plain");
        assertThat(result).isEqualTo(plainExpected);
    }

    @Test
    void testYamlPlain() throws Exception {
        String result = Differ.genDiff(pathYaml1, pathYaml2, "plain");
        assertThat(result).isEqualTo(plainExpected);
    }

    @Test
    void testJsonJson() throws Exception {
        String result = Differ.genDiff(pathJson1, pathJson2, "json");
        assertThat(result).isEqualTo(jsonExpected);
    }

    @Test
    void testYamlJson() throws Exception {
        String result = Differ.genDiff(pathYaml1, pathYaml2, "json");
        assertThat(result).isEqualTo(jsonExpected);
    }
}
