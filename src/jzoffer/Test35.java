package jzoffer;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by tianen on 2019/4/8
 *
 * @author fanfte
 * @date 2019/4/8
 **/
public class Test35 {

    public char firstNotRepeatingChar(String s) {
        if (s == null || "".equals(s) || s.length() == 0 ) {
            throw new IllegalArgumentException("Invalid input.");
        }
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0;i < s.length(); i ++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }
        Set<Map.Entry<Character, Integer>> entries = map.entrySet();
        Character result = null;
        for (Map.Entry<Character, Integer> entry : entries) {
            if (entry.getValue() == 1) {
                result = entry.getKey();
                break;
            }
        }
        return result;
    }
}
