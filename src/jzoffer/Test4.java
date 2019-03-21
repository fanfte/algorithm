package jzoffer;

/**
 * Created by tianen on 2019/3/20
 *
 * @author fanfte
 * @date 2019/3/20
 **/
public class Test4 {

    public int replaceBlank(char[] string, int length) {
        if (string == null || string.length == 0) {
            return -1;
        }
        int blankNums = 0;
        for (int i = 0; i < string.length; i ++) {
            if (string[i] == ' ') {
                blankNums ++;
            }
        }
        if (blankNums == 0) {
            return length;
        }
        int targetLength = length + 2 * blankNums;
        if (targetLength > string.length) {
            return -1;
        }
        int origin = length - 1;
        int target = targetLength - 1;
        while (origin >=0 && target > origin) {
            if (string[origin] == ' ') {
                string[target--] = '0';
                string[target--] = '2';
                string[target--] = '%';
            } else {
                string[target--] = string[origin];
            }
            origin --;
        }
        return targetLength;
    }

    public static void main(String[] args) {
        char[] string = new char[50];
        string[0] = ' ';
        string[1] = 'e';
        string[2] = ' ';
        string[3] = ' ';
        string[4] = 'r';
        string[5] = 'e';
        string[6] = ' ';
        string[7] = ' ';
        string[8] = 'a';
        string[9] = ' ';
        string[10] = 'p';
        string[11] = ' ';
        System.out.println(new String(string, 0, string.length));
        int length = new Test4().replaceBlank(string, 12);
        System.out.println(new String(string, 0, length));
    }
}
