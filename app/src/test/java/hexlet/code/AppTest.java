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

    private final String pathJson1 = "src/test/resources/file1.yml";
    private final String pathJson2 = "src/test/resources/file2.yml";
    private final String pathYaml1 = "src/test/resources/file1.yml";
    private final String pathYaml2 = "src/test/resources/file2.yml";



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
    void testStylish() throws Exception {
        String resultDefaultJson = Differ.generate(pathJson1, pathJson2);
        assertThat(resultDefaultJson).isEqualTo(stylishExpected);

        String resultDefaultYaml = Differ.generate(pathYaml1, pathYaml2);
        assertThat(resultDefaultYaml).isEqualTo(stylishExpected);

        String resultJson = Differ.generate(pathJson1, pathJson2, "stylish");
        assertThat(resultJson).isEqualTo(stylishExpected);

        String resultYaml = Differ.generate(pathYaml1, pathYaml2, "stylish");
        assertThat(resultYaml).isEqualTo(stylishExpected);
    }

    @Test
    void testPlain() throws Exception {
        String resultJson = Differ.generate(pathJson1, pathJson2, "plain");
        assertThat(resultJson).isEqualTo(plainExpected);

        String resultYaml = Differ.generate(pathYaml1, pathYaml2, "plain");
        assertThat(resultYaml).isEqualTo(plainExpected);
    }

    @Test
    void testJson() throws Exception {
        String resultJson = Differ.generate(pathJson1, pathJson2, "json");
        assertThat(resultJson).isEqualTo(jsonExpected);

        String resultYaml = Differ.generate(pathYaml1, pathYaml2, "json");
        assertThat(resultYaml).isEqualTo(jsonExpected);
    }
}
