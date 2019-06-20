package leetcode;

/**
 * Created by tianen on 2019/6/12
 *
 * @author fanfte
 * @date 2019/6/12
 **/
public class Test006 {

    public String convert(String s, int numRows) {
        if (s == null || s.length() <= 1 || numRows <= 1) {
            return s;
        }

        StringBuffer res = new StringBuffer();
        int interval = (numRows << 1) - 2;

        for (int i = 0;i < s.length();i += interval) {
            res.append(s.charAt(i));
        }
        for (int i = 1; i < numRows - 1; i ++) {
            int step = i << 1;
            for (int j = i; j < s.length(); j += 2 * i) {
                if (j <= s.length() - 1) {
                    res.append(s.charAt(j));
                    j += interval - step;
                    if (j <= s.length() - 1) {
                        res.append(s.charAt(j));
                    }
                }
            }
        }
        for (int i = numRows - 1; i < s.length(); i += interval) {
            res.append(s.charAt(i));
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String res = new Test006().convert("PAYPALISHIRING", 3);
        System.out.println(res);
    }
}
