package bigdata;

import java.util.Scanner;

/**
 * Created by tianen on 2019/4/10
 *
 * @author fanfte
 * @date 2019/4/10
 **/
public class BigDataMultiply {

    public static String multiply(String num1, String num2) {
        if (num1 == null || num1.length() == 0 || num2 == null || num2.length() == 0) {
            return "";
        }
        num1 = new StringBuffer(num1).reverse().toString();
        num2 = new StringBuffer(num2).reverse().toString();

        int[] res = new int[num1.length() + num2.length()];
        for (int i = 0; i < num1.length(); i ++) {
            int a = num1.charAt(i) - '0';
            for(int j = 0; j < num2.length(); j ++) {
                int b = num2.charAt(j) - '0';
                res[i + j] += a * b;
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0 ; i < res.length; i++) {
            int digit = res[i] % 10;
            int carry = res[i] / 10;
            result.insert(0, digit);
            if (i < res.length - 1) {
                res[i + 1] += carry;
            }
        }
        while(result.length() > 0 && result.charAt(0) == '0') {
            result.deleteCharAt(0);
        }
        return result.length() == 0 ? "0" : result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num1 = sc.next();
        String num2 = sc.next();
        System.out.println(multiply(num1, num2));
    }
}
