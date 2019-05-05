package test;

/**
 * Created by tianen on 2019/4/20
 *
 * @author fanfte
 * @date 2019/4/20
 **/
public class Test151 {

    public static String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        char[] chars = s.toCharArray();
        reverse(chars, 0, s.length() - 1);

        reverseWord(chars);

        return cleanSpace(chars);
    }

    private static String cleanSpace(char[] chars) {
        int i = 0;
        int j = 0;
        while (j < chars.length) {
            while (j < chars.length && chars[j] == ' ') {
                j ++;
            }
            while (j < chars.length && chars[j] != ' ') {
                chars[i ++] = chars[j ++];
            }
            while (j < chars.length && chars[j] == ' ') {
                j ++;
            }
            if (j < chars.length) chars[i ++] = ' ';
        }
        return new String(chars).substring(0, i);
    }

    public static void reverseWord(char[] chars) {
        int ss = 0;
        int se = 0;
        while (ss < chars.length) {
            while (ss < se || ss < chars.length && chars[ss] == ' ') {
                ss ++;
            }
            while (se < ss || se < chars.length && chars[se] != ' ') {
                se ++;
            }
            reverse(chars, ss, se - 1);
        }
    }

    private static void reverse(char[] s, int left, int right) {
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left ++;
            right --;
        }
    }

    public static void main(String[] args) {
        String abcdefgh = reverseWords("abcdefgh");
        System.out.println(abcdefgh);
    }
}
