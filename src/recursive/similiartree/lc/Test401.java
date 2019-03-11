package recursive.similiartree.lc;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tianen on 2019/2/12
 *
 * @author fanfte
 * @date 2019/2/12
 **/
public class Test401 {

    public List<String> readBinaryWatch(int num) {
        List<String> result = new ArrayList<>();
        for (int h = 0; h < 12; h ++) {
            for (int m = 0; m < 60; m ++) {
                if (Integer.bitCount(h * 64 + m) == num) {
                    result.add(String.format("%d:%02d", h, m));
                }
            }
        }
        return result;
    }
}
