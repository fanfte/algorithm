package test;

/**
 * Created by tianen on 2019/6/1
 *
 * @author fanfte
 * @date 2019/6/1
 **/
public class ReverseSentences {

    public String ReverseSentence(String str) {
        String res = "";
        if (str == null || str.length() == 0) {
            return res;
        }
        str = reverse(str.toCharArray(), 0, str.length() - 1);
        str = reverseEveryWord(str);
        return str;
    }

    private String reverseEveryWord(String str) {
        char[] chars = str.toCharArray();
        int start = 0;
        int firstEnd = 0;
        while (start < chars.length) {
            if (firstEnd == chars.length || chars[firstEnd] == ' ') {
                if (!(start == 0 && firstEnd == chars.length)) {
                    reverse(chars, start, firstEnd - 1);
                }
                firstEnd ++;
                start = firstEnd;
            } else if (chars[start] == ' ') {
                start ++;
                firstEnd ++;
            } else {
                firstEnd ++;
            }
        }
        return new String(chars);
    }

    public String reverse(char[] chars, int left, int right) {
        while (left < right) {
            swap(chars, left, right);
            left ++;
            right --;
        }
        return new String(chars);
    }

    private void swap(char[] chars, int left, int right) {
        char temp = chars[right];
        chars[right] = chars[left];
        chars[left] = temp;
    }


    public static void main(String[] args) {
        String arr = "Wonderful";
        String s = new ReverseSentences().ReverseSentence(arr);
        System.out.println(s);
    }
}
