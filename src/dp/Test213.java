package dp;

import java.util.Arrays;

/**
 * Created by tianen on 2019/3/8
 *
 * @author fanfte
 * @date 2019/3/8
 **/
public class Test213 {

    public int rob(int[] nums) {
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        memo2 = new int[nums.length];
        Arrays.fill(memo2, -1);
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(nums[0] + tryRob2(2, nums, nums.length - 2), tryRob2(1, nums, nums.length - 1));
    }

    private int tryRob(int index, int[] nums, int end) {
        int res = 0;
        if (index > end) {
            return 0;
        }
        for (int i = index; i <= end; i ++) {
            res = Math.max(res, nums[i] + tryRob(i + 2, nums, end));
        }
        return res;
    }

    int[] memo;
    int[] memo2;
    private int tryRob2(int index, int[] nums, int end) {
        int res = 0;
        if (index > end) {
            return 0;
        }
        if (memo[index] != -1 && end == nums.length - 2) {
            return memo[index];
        }
        if (memo2[index] != -1 && end == nums.length - 1) {
            return memo2[index];
        }
        for (int i = index; i <= end; i ++) {
            res = Math.max(res, nums[i] + tryRob2(i + 2, nums, end));
        }
        if (end == nums.length - 2) {
            memo[index] = res;
        }
        if (end == nums.length - 1) {
            memo2[index] = res;
        }
        return res;
    }

    /**
     * 从0开始rob
     */
    int[] rob0;
    /**
     * 从1开始rob
     */
    int[] rob1;
    public int rob2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int res = 0;
        rob0 = new int[nums.length];
        rob1 = new int[nums.length];
        Arrays.fill(rob0, -1);
        Arrays.fill(rob1, -1);

        rob0[0] = nums[0];
        rob0[1] = Math.max(nums[0], nums[1]);

        rob1[0] = 0;
        rob1[1] = nums[1];
        for (int i = 2; i < nums.length; i ++) {
            rob0[i] = Math.max(rob0[i - 1], nums[i] + rob0[i - 2]);
        }
        for (int i = 2; i < nums.length; i ++) {
            rob1[i] = Math.max(rob1[i - 1], nums[i] + rob1[i - 2]);
        }
        return Math.max(rob0[nums.length - 1], rob1[nums.length - 1]);
    }

    public static void main(String[] args) {
        System.out.println(new Test213().rob(new int[] {2, 3, 2}));
        System.out.println(new Test213().rob(new int[] {1, 3, 1, 3, 100}));
        System.out.println(new Test213().rob(new int[] {1, 2, 3, 1}));
        System.out.println(new Test213().rob(new int[] {6, 6, 4, 8, 4, 3, 3, 10}));
    }
}
