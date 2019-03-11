package dp;

import java.util.Arrays;

/**
 * Created by tianen on 2019/2/25
 *
 * @author fanfte
 * @date 2019/2/25
 **/
public class Test70 {
    public int climbStairs(int n) {
        int[] mem = new int[n + 1];
        Arrays.fill(mem, -1);
        mem[0] = 1;
        mem[1] = 1;
        for (int i = 2; i <= n; i ++) {
            mem[i] = mem[i - 1] + mem[i - 2];
        }
        return mem[n];
    }
}
