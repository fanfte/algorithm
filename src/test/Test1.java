package test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tianen on 2019/5/14
 *
 * @author fanfte
 * @date 2019/5/14
 **/
public class Test1 {

    public int FirstNotRepeatingChar(String str) {
        if (str == null || str.length() == 0) {
            return -1;
        }
        char[] chars = str.toCharArray();
        Map<Character, Integer> cache = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            if (!cache.containsKey(chars[i])) {
                cache.put(chars[i], 1);
            } else {
                cache.put(chars[i], cache.get(chars[i]) + 1);
            }
        }
        for (int i = 0; i < chars.length; i++) {
            if (cache.get(chars[i]) == 1) {
                return i;
            }
        }
        return -1;
    }
}
