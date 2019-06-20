package leetcode;

/**
 * Created by tianen on 2019/6/13
 *
 * @author fanfte
 * @date 2019/6/13
 **/
public class Test009 {

    public static boolean isPalindrome(int x) {
        String s = x + "";
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left ++;
            right --;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }
}
