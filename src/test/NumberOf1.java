package test;

/**
 * Created by tianen on 2019/6/10
 *
 * @author fanfte
 * @date 2019/6/10
 **/
public class NumberOf1 {

    public int NumberOf1Between1AndN_Solution(int n) {
        int res = 0;
        if (n <= 0 ) {
            return res;
        }
        for (int i = 1; i <= n; i ++) {
            res += numberOf1InOneNum(i);
        }
        return res;
    }

    private int numberOf1InOneNum(int i) {
        int tmp = i;
        int res = 0;
        while (tmp != 0) {
            if (tmp % 10 == 1) {
                res ++;
            }
            tmp /= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new NumberOf1().numberOf1InOneNum(8));
        System.out.println(new NumberOf1().NumberOf1Between1AndN_Solution(13));
        System.out.println(1 / 10);

    }
}
