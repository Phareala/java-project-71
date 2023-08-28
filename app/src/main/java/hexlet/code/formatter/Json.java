package hexlet.code.formatter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Map;

public class Json {

    public static String format(List<Map<String, Object>> differ) throws JsonProcessingException {
        var result = new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(differ);
        return result;
    }
}
