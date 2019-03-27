package jzoffer;

/**
 * Created by tianen on 2019/3/22
 *
 * @author fanfte
 * @date 2019/3/22
 **/
public class Test10 {

    /**
     * 一个数 按位与上   n & (n - 1) 会消除最后一个1 ，循环按位与，获取到0的 count 为 1 的个数
     * @param num
     * @return
     */
    public int numOfOne(int num) {
        int count = 0;

        while(num != 0) {
            count ++;
            num = num & (num - 1);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Test10().numOfOne(10));
        System.out.println(new Test10().numOfOne(9));
        System.out.println(new Test10().numOfOne(8));
        System.out.println(new Test10().numOfOne(7));
    }
}
