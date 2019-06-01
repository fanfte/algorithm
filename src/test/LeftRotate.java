package test;

/**
 * Created by tianen on 2019/5/14
 *
 * @author fanfte
 * @date 2019/5/14
 **/
public class LeftRotate {

    public String LeftRotateString(String str,int n) {
        if (str == null || str.length() == 0 || n < 0) {
            return str;
        }
        char[] res = new char[str.length()];
        int index = 0;
        for(int i = n; i < str.length(); i ++) {
            res[index++] = str.charAt(i);
        }
        int j = 0;
        while (index < str.length()) {
            res[index++] = str.charAt(j++);
        }
        return new String(res);
    }

    public static void main(String[] args) {
        String s = "abcdef";

        String s1 = new LeftRotate().LeftRotateString(s, 3);
        System.out.println(s1);
    }
}
