package jzoffer;

import java.util.Comparator;

/**
 * Created by tianen on 2019/4/8
 *
 * @author fanfte
 * @date 2019/4/8
 **/
public class Test33 {

    public class MComparator implements Comparator<String> {

        @Override
        public int compare(String s1, String s2) {
            if (s1 == null || s2 == null) {
                throw new IllegalArgumentException("Invalid input.");
            }
            String a = s1 + s2;
            String b = s2 + s1;
            return a.compareTo(b);
        }
    }

    public String printMinNumber(String[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Invalid input.");
        }
        MComparator comparator = new MComparator();
        quickSort(arr, 0, arr.length - 1, comparator);

        StringBuffer sb = new StringBuffer();
        for (String s : arr) {
            sb.append(s);
        }
        return sb.toString();
    }

    private void quickSort(String[] arr, int start, int end, MComparator comparator) {
        if (start >= end) {
            return;
        }
        String pivot = arr[start];
        int pivotIndex = start;
        int left = start;
        int right = end;
        while (left < right) {
            while (left < right && comparator.compare(arr[right], pivot) >= 0) {
                right --;
            }
            while (left < right && comparator.compare(arr[left], pivot) <= 0) {
                left ++;
            }
            if (left < right) {
                swap(arr, left, right);
            }
        }
        swap(arr, pivotIndex, left);
        quickSort(arr, start, left - 1, comparator);
        quickSort(arr, left + 1, end, comparator);
    }

    private void swap(String[] arr, int left, int right) {
        String temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    public static void main(String[] args) {
        String[] arr = new String [] {"3", "5", "1", "4", "2"};
        System.out.println(new Test33().printMinNumber(arr));
    }
}
