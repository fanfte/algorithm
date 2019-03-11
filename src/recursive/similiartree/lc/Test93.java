package recursive.similiartree.lc;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tianen on 2019/2/11
 *
 * @author fanfte
 * @date 2019/2/11
 **/
public class Test93 {
    public List<String> restoreIpAddresses(String s) {

        List<String> res = new ArrayList<>();
        if (s == null || s.equals("") || s.length() > 12) {
            return res;
        }
        findAdresses(s, "", res, 0);
        return res;
    }

    public void findAdresses(String aimStr, String tempStr, List<String> res, int k) {
        if (aimStr.isEmpty() || k== 4) {
            if (aimStr.isEmpty() && k ==4) {
                res.add(tempStr.substring(1));
                return;
            } else {
                return;
            }
        }

        for (int i = 1;i <= (aimStr.charAt(0) == '0' ? 1 : 3) && i <= aimStr.length(); i++) {
            String temp = aimStr.substring(0, i);
            if (Integer.parseInt(temp) <= 255) {
                findAdresses(aimStr.substring(i), tempStr + "." + temp, res, k + 1);
            }
        }
    }

    public static void main(String[] args) {
        List<String> strings = new Test93().restoreIpAddresses("25525511135");
        System.out.println(strings);
    }

}
