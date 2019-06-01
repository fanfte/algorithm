package test;

/**
 * Created by tianen on 2019/5/14
 *
 * @author fanfte
 * @date 2019/5/14
 **/
public class AppearOnce {

    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if (array == null || array.length == 0) {
            return;
        }
        // 先全部数字按位异或,结果一定有至少一位为1
        int xorResult = 0;
        for (int i = 0; i < array.length; i ++) {
            xorResult ^= array[i];
        }
        int n = findFirstBit1(xorResult);
        // 将数组按该位是否为1分成两个数组
        // 两个数组分别异或，得到两个唯一数字是结果
        for (int i = 0 ;i < array.length; i ++) {
            if (isBit1(array[i], n)) {
                num1[0] ^= array[i];
            } else {
                num2[0] ^= array[i];
            }
        }
    }

    private boolean isBit1(int num, int n) {
        return ((num >> n) & 1) == 1;
    }

    /**
     * 找到第一个为1的位所在的位置
     */
    private int findFirstBit1(int xorResult) {
        int index = 0;
        while((xorResult & 1) == 0 && index < 32) {
            xorResult >>>= 1;
            index ++;
        }
        return index;
    }
}
