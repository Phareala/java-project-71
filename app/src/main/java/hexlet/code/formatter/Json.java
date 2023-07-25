package hexlet.code.formatter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Map;

public class Json {

    public static String format(List<Map<String, List<Object>>> differ) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(differ).trim();
    }
}
