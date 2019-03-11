package recursive.similiartree.lc;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tianen on 2019/2/11
 *
 * @author fanfte
 * @date 2019/2/11
 **/
public class Test17 {

    private static String[] aimMap = new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    private static List<String> res = new ArrayList<>();

    public static List<String> letterCombinations(String digits) {

        if (digits == null || digits.equals("")) {
            return res;
        }
        findConbination(digits, 0, "");
        return res;
    }

    public static void findConbination(String digits, int index, String oneRes) {
        if (index == digits.length()) {
            res.add(oneRes);
            return;
        }
        char c = digits.toCharArray()[index];
        char[] chars = aimMap[c - '0'].toCharArray();
        for (int i = 0; i < chars.length; i++) {
            findConbination(digits, index + 1, oneRes + chars[i]);
        }
    }

    public static void main(String[] args) {
        List<String> strings = letterCombinations("23");
        System.out.println(strings);
    }
}
