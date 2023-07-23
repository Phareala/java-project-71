package hexlet.code;

import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Differ {

//    public static Map<String, Objects> genDiff(Map<String, Object> first, Map<String, Object> second) {
//        Map<String, Objects> result = new TreeMap<>();
//
//        for (String key: first.get(key))
//
//        if (first.isEmpty()) {}
//
//        return result;
//    }

//    public static List<Map<String, List<Object>>> buildDiff(Map<String, Object> map1, Map<String, Object> map2) {
//        List<Map<String, List<Object>>> diffTree = new ArrayList<>();
//        var allKeys = getSortedKeys(map1, map2);
//        for (String key : allKeys) {
//            System.out.println(map1.get(key));
//            if (map1.containsKey(key) && !map2.containsKey(key)) {
//                diffTree.add(Map.of("removed", Arrays.asList(key, map1.get(key))));
//            } else if (!map1.containsKey(key) && map2.containsKey(key)) {
//                diffTree.add(Map.of("added", Arrays.asList(key, map2.get(key))));
//            } else if (map1.get(key) == null && map2.get(key) == null) {
//                diffTree.add(Map.of("unchanged", Arrays.asList(key, map1.get(key))));
//            } else if ((map1.get(key) != null && map2.get(key) != null) && (map1.get(key).equals(map2.get(key)))) {
//                diffTree.add(Map.of("unchanged", Arrays.asList(key, map1.get(key))));
//            } else {
//                diffTree.add(Map.of("updated", Arrays.asList(key, map2.get(key), map1.get(key))));
//            }
//        }
//        return diffTree;
//    }

    public static String buildDiff(Map<String, Object> map1, Map<String, Object> map2) {
        StringBuilder diffTree = new StringBuilder("{");
        var allKeys = getSortedKeys(map1, map2);
        for (String key : allKeys) {
            if (map1.containsKey(key) && !map2.containsKey(key)) {
                diffTree.append("\n" + " - " + key + ": " + map1.get(key));
//                diffTree.add(Map.of("removed", Arrays.asList(key, map1.get(key))));
            } else if (!map1.containsKey(key) && map2.containsKey(key)) {
                diffTree.append("\n" + " + " + key + ": " + map1.get(key));
//                diffTree.add(Map.of("added", Arrays.asList(key, map2.get(key))));
            } else if (map1.get(key) == null && map2.get(key) == null) {
                diffTree.append("\n" + "   " + key + ": " + map1.get(key));
//                diffTree.add(Map.of("unchanged", Arrays.asList(key, map1.get(key))));
            } else if ((map1.get(key) != null && map2.get(key) != null) && (map1.get(key).equals(map2.get(key)))) {
                diffTree.append("\n" + "   " + key + ": " + map1.get(key));
//                diffTree.add(Map.of("unchanged", Arrays.asList(key, map1.get(key))));
            } else {
                diffTree.append("\n" + " - " + key + ": " + map2.get(key));
                diffTree.append("\n" + " + " + key + ": " + map1.get(key));
//                diffTree.add(Map.of("updated", Arrays.asList(key, map2.get(key), map1.get(key))));
            }
        }
        diffTree.append("\n}");
        return diffTree.toString();
    }

    private static Set<String> getSortedKeys(Map<String, Object> map1, Map<String, Object> map2) {
        final TreeSet<String> allKeys = new TreeSet<>(map1.keySet());
        allKeys.addAll(map2.keySet());
        return allKeys;
    }

//    public static

}
