package leetcode.map;

import java.util.*;

/**
 * Created by tianen on 2019/6/23
 *
 * @author fanfte
 * @date 2019/6/23
 **/
public class Test015 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        HashSet<List<Integer>> tmpSet = new HashSet<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            Set<Integer> set = new HashSet<>();
            for (int j = i + 1; j < nums.length; j ++) {
                if (set.contains(- nums[i] - nums[j])) {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[i]);
                    tmp.add(nums[j]);
                    tmp.add(- nums[i] - nums[j]);
                    res.add(tmp);
                    while (j + 1 < nums.length && nums[j + 1] == nums[j]) {
                        j ++;
                    }
                }
                set.add(nums[j]);
            }
        }
        return res;
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] < 0) {
                    left ++;
                } else if (nums[i] + nums[left] + nums[right] > 0) {
                    right --;
                } else {
                    // 同样的两个数不需要再次放入，由于之前Arrays.sort过，不需要别的操作了
                    while (left < right && nums[left] == nums[left + 1])  {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right --;
                    }
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[i]);
                    tmp.add(nums[left]);
                    tmp.add(nums[right]);
                    res.add(tmp);
                    left ++;
                    right --;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {-2,0,1,1,2};
        List<List<Integer>> lists = new Test015().threeSum2(arr);
        System.out.println(lists);
    }
}
