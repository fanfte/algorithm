package jzoffer;

/**
 * Created by tianen on 2019/3/21
 *
 * @author fanfte
 * @date 2019/3/21
 **/
public class Test09 {

    public int fibonacci(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n  - 2);
    }

    public int fibonacci2(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 1;
        }

        int prePre = 1;
        int pre = 1;
        int cur = 2;
        for (int i = 3; i <= n; i ++) {
            cur = pre + prePre;
            prePre = pre;
            pre = cur;
        }
        return cur;
    }
}
