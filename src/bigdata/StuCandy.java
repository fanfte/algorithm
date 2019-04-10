package bigdata;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by tianen on 2019/4/10
 *
 * @author fanfte
 * @date 2019/4/10
 **/
public class StuCandy {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int stuNum = sc.nextInt();
        int[] stus = new int[stuNum];
        for (int i = 0; i < stus.length; i++) {
            stus[i] = sc.nextInt();
        }

        int candyNum = sc.nextInt();
        int[] candies = new int[candyNum];
        for (int i = 0; i < candies.length; i++) {
            candies[i] = sc.nextInt();
        }
        Arrays.sort(stus);
        Arrays.sort(candies);
        int sIndex = 0;
        int cIndex = 0;
        int res = 0;
        while (cIndex < candyNum && sIndex < stuNum) {
            if (stus[sIndex] <= candies[cIndex]) {
                res ++;
                sIndex ++;
                cIndex ++;
            } else {
                cIndex ++;
            }
        }
        System.out.println(res);
    }
}
