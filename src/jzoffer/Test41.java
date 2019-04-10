package jzoffer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tianen on 2019/4/9
 *
 * @author fanfte
 * @date 2019/4/9
 **/
public class Test41 {

    public List<Integer> findNumbersWithSum(int[] arr, int sum) {
        if (arr == null || arr.length < 2) {
            return null;
        }
        int left = 0;
        int right = arr.length - 1;
        List<Integer> res = new ArrayList<>();
        int tempSum = 0;
        while(left < right) {
            tempSum = arr[left] + arr[right];
            if (tempSum == sum) {
                res.add(arr[left]);
                res.add(arr[right]);
                return res;
            } else if (tempSum < sum) {
                left ++;
            } else {
                right ++;
            }
        }
        return res;
    }

    public List<List<Integer>> findContinousSequence(int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if (sum < 3) {
            return result;
        }
        int small = 1;
        int big = 2;
        int curSum = small + big;
        int mid = (sum + 1) >> 1;
        while(small < mid) {
            if (curSum == sum) {
                addResult(result, small, big);
            }

            if (curSum > sum && small < mid) {
                curSum -= small;
                small ++;
                if (curSum == sum) {
                    addResult(result, small, big);
                }
            }
            big ++;
            curSum += big;
        }
        return result;
    }

    private void addResult(List<List<Integer>> result, int small, int big) {
        List<Integer> temp = new ArrayList<>();
        for (int i = small; i <= big; i++) {
            temp.add(i);
        }
        result.add(temp);
    }
}
