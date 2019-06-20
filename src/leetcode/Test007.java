package leetcode;

/**
 * Created by tianen on 2019/6/13
 *
 * @author fanfte
 * @date 2019/6/13
 **/
public class Test007 {

    public int reverse(int x) {
        long result = 0;
        while (x != 0) {
            result = result * 10 + x % 10;
            if (result > Integer.MAX_VALUE) return 0;
            if (result < Integer.MIN_VALUE) return 0;
            x = x / 10;
        }
        return (int) result;
    }

    public int reverse1(int x) {
        String s = x + "";
        if (s.charAt(0) == '-') {
            String reverse = reverseString(s.substring(1).toCharArray());
            long l =  Long.parseLong(s.charAt(0) + reverse);
            return dealWithLong(l);
        }
        long l =  Long.parseLong(reverseString(s.toCharArray()));
        return dealWithLong(l);
    }

    private int dealWithLong(long l) {
        if (l > Integer.MAX_VALUE) {
            return 0;
        }else {
            return (int) l;
        }
    }

    private String reverseString(char[] chars) {
        int l = 0; int r = chars.length - 1;
        while (l < r) {
            swap(chars, l++, r--);
        }
        return new String(chars);
    }

    private void swap(char[] chars, int l, int r) {
        char tmp = chars[l];
        chars[l] = chars[r];
        chars[r] = tmp;
    }
}
