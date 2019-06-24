package leetcode.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by tianen on 2019/6/23
 * 2Sum
 * @author fanfte
 * @date 2019/6/23
 **/
public class Test001 {

    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        if (nums == null || nums.length <= 1) {
            return res;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i ++) {
            if (map.containsKey(target - nums[i])) {
                res[0] = i;
                res[1] = map.get(target - nums[i]);
                return res;
            }
            map.put(nums[i], i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {3, 3};
        int[] ints = new Test001().twoSum(arr, 6);
        for (int anInt : ints) {
            System.out.print(anInt + " ");
        }
    }
}
