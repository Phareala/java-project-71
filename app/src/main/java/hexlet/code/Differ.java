package hexlet.code;

import java.util.*;

public class Differ {

    public static String genDiff(String firstFilePath, String secondFilePath, String format) throws Exception {

        Map<String, Object> firstFile = Parsing.parser(firstFilePath, getExtension(firstFilePath));
        Map<String, Object> secondFile = Parsing.parser(secondFilePath, getExtension(secondFilePath));
        List<Map<String, List<Object>>> diffList = new ArrayList<>(buildDiff(firstFile, secondFile));
        return Formatter.format(diffList, format);
    }

    public static List<Map<String, List<Object>>> buildDiff(Map<String, Object> map1, Map<String, Object> map2) {
        List<Map<String, List<Object>>> diffTree = new ArrayList<>();
        var allKeys = getSortedKeys(map1, map2);
        for (String key : allKeys) {
            if (map1.containsKey(key) && !map2.containsKey(key)) {
                diffTree.add(Map.of("removable", Arrays.asList(key, map1.get(key))));
            } else if (!map1.containsKey(key) && map2.containsKey(key)) {
                diffTree.add(Map.of("added", Arrays.asList(key, map2.get(key))));
            } else if ((map1.get(key) != null && map2.get(key) != null) && (map1.get(key).equals(map2.get(key)))) {
                diffTree.add(Map.of("unaltered", Arrays.asList(key, map1.get(key))));
            } else {
                diffTree.add(Map.of("changeable", Arrays.asList(key, map1.get(key), map2.get(key))));
            }
        }
        return diffTree;
    }

    private static Set<String> getSortedKeys(Map<String, Object> map1, Map<String, Object> map2) {
        final TreeSet<String> allKeys = new TreeSet<>(map1.keySet());
        allKeys.addAll(map2.keySet());
        return allKeys;
    }
    private static String getExtension(String filePath) {
        int index = filePath.lastIndexOf('.');
        return index > 0 ? filePath.substring(index + 1) : "";
    }

//    public static

}
