package jzoffer;

/**
 * Created by tianen on 2019/4/8
 *
 * @author fanfte
 * @date 2019/4/8
 **/
public class Test34 {

    public int getUglyNumbers(int index) {
        if (index <= 0) {
            return 0;
        }
        int[] uglyNumbers = new int[index];
        uglyNumbers[0] = 1;
        int nextUglyNumberIndex = 1;
        int p2 = 0;
        int p3 = 0;
        int p5 = 0;
        while (nextUglyNumberIndex < index) {
            int min = min(uglyNumbers[p2] * 2, uglyNumbers[p3] * 3, uglyNumbers[p5] * 5);
            uglyNumbers[nextUglyNumberIndex] = min;
            while (uglyNumbers[p2] * 2 <= uglyNumbers[nextUglyNumberIndex]) {
                p2 ++;
            }

            while (uglyNumbers[p3] * 3 <= uglyNumbers[nextUglyNumberIndex]) {
                p3 ++;
            }
            while (uglyNumbers[p5] * 5 <= uglyNumbers[nextUglyNumberIndex]) {
                p5 ++;
            }
            nextUglyNumberIndex ++;
        }
        return uglyNumbers[nextUglyNumberIndex - 1];
    }

    private int min(int i, int i1, int i2) {
        int min = Math.min(i, i1);
        return Math.min(min, i2);
    }

    public static void main(String[] args) {
        System.out.println(new Test34().getUglyNumbers(1)); // 1
        System.out.println(new Test34().getUglyNumbers(2)); // 2
        System.out.println(new Test34().getUglyNumbers(3)); // 3
        System.out.println(new Test34().getUglyNumbers(4)); // 4
        System.out.println(new Test34().getUglyNumbers(5)); // 5
        System.out.println(new Test34().getUglyNumbers(6)); // 6
        System.out.println(new Test34().getUglyNumbers(7)); // 8
        System.out.println(new Test34().getUglyNumbers(8)); // 9
        System.out.println(new Test34().getUglyNumbers(9)); // 10
        System.out.println(new Test34().getUglyNumbers(10)); // 12
        System.out.println(new Test34().getUglyNumbers(11)); // 15
        System.out.println(new Test34().getUglyNumbers(1500)); // 859963392
        System.out.println(new Test34().getUglyNumbers(0)); // 0
    }
}
