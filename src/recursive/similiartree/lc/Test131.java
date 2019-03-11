package recursive.similiartree.lc;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tianen on 2019/2/11
 *
 * @author fanfte
 * @date 2019/2/11
 **/
public class Test131 {

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        findPalindromes(res, temp, s);
        return res;
    }

    private void findPalindromes(List<List<String>> res, List<String> temp, String s) {

        if (s.isEmpty() || isPalindrome(s)) {
            if (!s.isEmpty() && isPalindrome(s)) {
                ArrayList<String> strings = new ArrayList<>(temp);
                strings.add(s);
                res.add(strings);
//                return;
            } else {
                return;
            }
        }

        for (int i = 1 ;i <= s.length() ;i ++) {
            String oneStr = s.substring(0, i);
            if (isPalindrome(oneStr)) {
                temp.add(oneStr);
                findPalindromes(res, temp, s.substring(i));
                temp.remove(temp.size() - 1);
            }
        }
    }


    public boolean isPalindrome(String str) {
        if (str == null) {
            return false;
        }
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            if (chars[i] != chars[chars.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        System.out.println(new Test131().partition("bb"));
    }
}
