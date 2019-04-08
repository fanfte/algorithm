package jzoffer;

/**
 * Created by tianen on 2019/4/8
 *
 * @author fanfte
 * @date 2019/4/8
 **/
public class Test31 {

    public int findGreatestSumOfSubArray(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int curSum = 0;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (curSum <= 0) {
                curSum = arr[i];
            } else {
                curSum += arr[i];
            }
            if (max < curSum) {
                max = curSum;
            }
        }
        return max;
    }


}
