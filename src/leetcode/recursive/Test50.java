package leetcode.recursive;

import leetcode.tree.Test98;

/**
 * Created by tianen on 2019/7/3
 *
 * @author fanfte
 * @date 2019/7/3
 **/
public class Test50 {

    public double myPow(double x, int n) {
        long m = n > 0 ? n : -(long)n;
        double ans = 1.0;
        while (m != 0) {
            if ((m & 1) == 1)
                ans *= x;
            x *= x;
            m >>= 1;
        }
        return n >= 0 ? ans : 1 / ans;
    }

    public double myPow2(double x, int n) {
        double temp = x;
        if (n == 0) {
            return 1;
        }
        temp = myPow2(x, n / 2);
        if ((n & 1) == 0) {
            return temp * temp;
        } else {
            if (n > 0) {
                return x * temp * temp;
            } else {
                return (temp * temp) / x;
            }
        }
    }

    public double myPow3(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 1 / myPow3(x, -n);
        }
        if ((n & 1) == 1) {
            return x * myPow3(x, n - 1);
        }
        return myPow3(x * x, n / 2);
    }

    public double pow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        int exp = n;
        if (exp < 0) {
            exp = -n;
        }
        double res = getTempRes(x, exp);
        if (n < 0) {
            res = 1 / res;
        }
        return res;
    }

    private double getTempRes(double x, int exp) {
        if (exp == 0) {
            return 1;
        }
        if (exp == 1) {
            return x;
        }
        double res = getTempRes(x, exp / 2);
        res *= res;
        if ((exp & 1) == 1) {
            res *= x;
        }
        return res;
    }

    public static void main(String[] args) {
        double v = new Test50().myPow(2, 6);
        System.out.println(v);

        System.out.println(new Test50().myPow2(2, -6));

        System.out.println(new Test50().pow(2, -3));
    }
}
