package test;

import org.omg.CORBA.INTERNAL;

/**
 * Created by tianen on 2019/5/5
 *
 * @author fanfte
 * @date 2019/5/5
 **/
public class TestFindGreatestSum {

    // {6,-3,-2,7,-15,1,2,2}
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("invalid input.");
        }

        int curSum = 0;
        int curMax = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (curSum <= 0) {
                curSum = array[i];
            } else {
                curSum = curSum + array[i];
            }
            if (curSum > curMax) {
                curMax = curSum;
            }
        }
        return curMax;
    }
}
