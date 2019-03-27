package jzoffer;

import java.util.Arrays;

/**
 * Created by tianen on 2019/3/22
 *
 * @author fanfte
 * @date 2019/3/22
 **/
public class Test12 {

    /**
     * 打印1 到 n 之间的所有数字
     * @param n
     */
    public void printOneToNthDigits(int n) throws Exception {
        if (n < 1) {
            throw new Exception("Invalid input.");
        }

        int[] arr = new int[n];
        Arrays.fill(arr, 0);

        while(addOne(arr) == 0) {
            printArray(arr);
        }
    }

    private void printArray(int[] arr) {
        int index = 0;
        while(arr[index] == 0 && index < arr.length) {
            index ++;
        }
        for (int i = index; i < arr.length; i ++) {
            System.out.print(arr[i]);
        }
        System.out.println();
    }

    private int addOne(int[] arr) {
        int index = arr.length;
        int carry = 1;

        while(carry != 0 && index > 0) {
            index --;
            arr[index] += carry;
            carry = arr[index] / 10;
            arr[index] = arr[index] % 10;
        }
        if (carry > 0 && index == 0) {
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) throws Exception {
        new Test12().printOneToNthDigits(3);
    }
}
