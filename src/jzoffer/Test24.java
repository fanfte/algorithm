package jzoffer;

/**
 * Created by tianen on 2019/3/27
 *
 * @author fanfte
 * @date 2019/3/27
 **/
public class Test24 {

    public boolean verifySequenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        return verify(sequence, 0, sequence.length - 1);
    }

    private boolean verify(int[] sequence, int start, int end) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        if (start >= end) {
            return true;
        }
        int endNum = sequence[end];
        int startIndex = start;
        while (startIndex < end && sequence[startIndex] < endNum ) {
            startIndex ++;
        }
        int rightIndex = startIndex;
        while (rightIndex < end && sequence[rightIndex] > endNum) {
            rightIndex ++;
        }
        if (rightIndex != end - 1) {
            return false;
        }

        return false;
    }
}
