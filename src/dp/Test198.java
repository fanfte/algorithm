package dp;

import java.util.Arrays;

/**
 * Created by tianen on 2019/3/7
 *
 * @author fanfte
 * @date 2019/3/7
 **/
public class Test198 {

    private int[] memo;
    public int rob(int[] nums) {
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        int res = tryRob(0, nums);
        return res;
    }

    /**
     * 尝试在[index, n) 房屋中rob 获取最大利益
     */
    private int tryRob(int index, int[] nums) {
        int res = 0;
        if (index > nums.length - 1) {
            return 0;
        }
        for (int i = index; i < nums.length; i ++) {
            res = Math.max(res, nums[i] + tryRob(i + 2, nums));
        }
        return res;
    }

    private int tryRob2(int index, int[] nums) {
        int res = 0;
        if (index > nums.length - 1) {
            return 0;
        }
        if (memo[index] != -1) {
            return memo[index];
        }
        for (int i = index; i < nums.length; i ++) {
            res = Math.max(res, nums[i] + tryRob2(i + 2, nums));
        }
        memo[index] = res;
        return res;
    }

    private int tryRob3(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        dp[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0 ; i --) {
            for (int j = i; j < n; j ++) {
                dp[i] = Math.max(dp[i], nums[j] + (j + 2 < n ? dp[j + 2] : 0));
            }
        }
        return dp[0];
    }

    /**
     * 从[0, n - 1]尝试rob
     * @param nums
     * @return
     */
    private int rob2(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i ++) {
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        new Test198().tryRob3(new int[]{2,7,9,3,1});
    }
}
