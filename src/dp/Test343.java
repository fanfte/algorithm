package dp;

import java.util.Arrays;

/**
 * Created by tianen on 2019/2/25
 *
 * @author fanfte
 * @date 2019/2/25
 **/
public class Test343 {

    private int[] mem ;

    public int integerBreak(int n) {
        mem = new int[n + 1];
        Arrays.fill(mem, -1);
        return breakInteger(n);
    }

    private int breakInteger(int n) {
        if (n == 1) {
            return 1;
        }
        int res = -1;
        for (int i = 1; i < n; i++) {
            res = max3(res, i * (n - i), i * breakInteger(n - i));
        }
        return res;
    }

    private int max3(int res, int a, int b) {
        return Math.max(res, Math.max(a, b));
    }

    private int breakInteger2(int n) {
        if (n == 1) {
            return 1;
        }
        if (mem[n] != -1) {
            return mem[n];
        }
        int res = -1;
        for (int i = 1; i < n; i++) {
            res = max3(res, i * (n - i), i * breakInteger(n - i));
        }
        mem[n] = res;
        return res;
    }

    // mem[i]表示为将n分割为i和j（至少两部分）之后得到的最大乘积
    // breakInteger3方法表示为将n分割为至少两部分得到的最大乘积
    private int breakInteger3(int n) {
        mem[1] = 1;

        for (int i = 2; i <= n; i ++) {
            for (int j = 1; j <= i - 1; j ++) {
                mem[i] = max3(mem[i], j * (i - j), j * mem[i - j]);
            }
        }
        return mem[n];
    }
}
