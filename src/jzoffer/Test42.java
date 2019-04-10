package jzoffer;

/**
 * Created by tianen on 2019/4/10
 *
 * @author fanfte
 * @date 2019/4/10
 **/
public class Test42 {

    public void reverseSentence(char[] sentence) {
        if (sentence == null || sentence.length == 0) {
            return;
        }

        reverse(sentence, 0, sentence.length - 1);

        int start = 0;
        int end = 0;
        while (end < sentence.length) {
            if (sentence[end] == ' ' || end == sentence.length - 1) {
                reverse(sentence, start, end - 1);
                start = ++end;
            } else {
                end ++;
            }
        }
    }

    private void reverse(char[] part, int left, int right) {
        while (left < right) {
            char temp = part[left];
            part[left] = part[right];
            part[right] = temp;
            left ++;
            right --;
        }
    }

    private String rotateString(String str, int k) {
        if (str == null || "".equals(str)) {
            return "";
        }
        int startFirst = 0;
        int endFirst = k - 1;
        int startSecond = k;
        int endSecond = str.length() - 1;
        char[] chars = str.toCharArray();
        reverse(chars, startFirst, endFirst);
        reverse(chars, startSecond, endSecond);
        reverse(chars, startFirst, endSecond);
        return new String(chars);
    }

    public static void main(String[] args) {
        String s = "I am a student.";
        char[] chars = s.toCharArray();
        new Test42().reverseSentence(chars);
        System.out.println(new String(chars));

        System.out.println(new Test42().rotateString(s, 4));
    }
}
