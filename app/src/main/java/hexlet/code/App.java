package hexlet.code;

//import hexlet.code.Differ;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import java.util.concurrent.Callable;

@Command(name = "gendiff",
        mixinStandardHelpOptions = true,
        version = "Gendiff 1.0",
        description = "Compares two configuration files and shows a difference.")
class App implements Callable<Integer> {

    @Option(names = { "-h", "--help"}, usageHelp = true, description = "Show this help message and exit.")
    private boolean helpRequested = false;

    @Option(names = { "-V", "--version" }, description = "Print version information and exit.")
    private boolean version = false;

    @Option(names = { "-f", "--format" }, paramLabel = "format", description = "output format [default: stylish]")
    String format = "stylish";

    @Parameters(paramLabel = "filepath1", description = "path to first file")
    String filepath1;

    @Parameters(paramLabel = "filepath2", description = "path to second file")
    String filepath2;

    @Override
    public Integer call() throws Exception {
        System.out.println(Differ.generate(filepath1, filepath2, format));
//        System.out.println(Differ.buildDiff(Parsing.getYamlString(filepath1), Parsing.getYamlString(filepath2)));
//        System.out.println(Parsing.getJsonString(filepath1));
//        System.out.println(Parsing.getJsonString(filepath2));
        return 1;
    }


    public static void main(String... args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }

}
