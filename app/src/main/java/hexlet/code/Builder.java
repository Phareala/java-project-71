package hexlet.code;


import java.util.*;


public class Builder {

    public static List<Map<String, Object>> buildDiff(final Map<String, Object> map1, final Map<String, Object> map2) {

        List<Map<String, Object>> resultMap = new ArrayList<>();
        SortedSet<String> allKeys = new TreeSet<>(map1.keySet());
        allKeys.addAll(map2.keySet());
        for (String key : allKeys) {
            Map<String, Object> diffMap = new LinkedHashMap<>();
            if (map1.containsKey(key) && !map2.containsKey(key)) {
                diffMap.put("key", key);
                diffMap.put("status", "removable");
                diffMap.put("oldValue", map1.get(key));

            } else if (!map1.containsKey(key) && map2.containsKey(key)) {
                diffMap.put("key", key);
                diffMap.put("status", "added");
                diffMap.put("newValue", map2.get(key));
            } else if ((map1.get(key) != null && map2.get(key) != null) && (map1.get(key).equals(map2.get(key)))) {
                diffMap.put("key", key);
                diffMap.put("status", "unaltered");
                diffMap.put("oldValue", map1.get(key));
            } else {
                diffMap.put("key", key);
                diffMap.put("status", "changeable");
                diffMap.put("oldValue", map1.get(key));
                diffMap.put("newValue", map2.get(key));
            }
            resultMap.add(diffMap);
        }
        return resultMap;
    }
}
