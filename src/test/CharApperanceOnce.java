package test;

import java.util.Arrays;

/**
 * Created by tianen on 2019/6/10
 *
 * @author fanfte
 * @date 2019/6/10
 **/
public class CharApperanceOnce {

    private static int[] hash = new int[256];

    StringBuffer str = new StringBuffer();

    static {
        Arrays.fill(hash, 0);
    }

    public void Insert(char ch)
    {
        hash[ch] ++;
        str.append(ch);
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        char res = '#';
        for (int i = 0;i < str.length();i ++) {
            if (hash[str.charAt(i)] == 1) {
                return str.charAt(i);
            }
        }
        return res;
    }
}
