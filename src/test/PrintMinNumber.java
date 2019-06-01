package test;

import java.util.Comparator;

import static test.TestSort.partition;

/**
 * Created by tianen on 2019/6/1
 *
 * @author fanfte
 * @date 2019/6/1
 **/
public class PrintMinNumber {

    public static class MyComparator implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            if (o1 == null || o2 == null) {
                throw new IllegalArgumentException("invalid input");
            }
            String s1 = o1 + o2;
            String s2 = o2 + o1;
            return s1.compareTo(s2);
        }
    }

    public String PrintMinNumber(int [] numbers) {
        String res = "";
        if (numbers == null || numbers.length == 0) {
            return res;
        }
        quickSort(numbers, new MyComparator());
        StringBuffer sb = new StringBuffer();
        for (int number : numbers) {
            sb.append(number);
        }
        return sb.toString();
    }

    private void quickSort(int[] numbers, MyComparator myComparator) {
        ;
        doSort(numbers, 0, numbers.length - 1, myComparator);

    }

    private void doSort(int[] numbers, int left, int right, MyComparator myComparator) {
        if (left < right) {
            int index = partition(numbers, left, right, myComparator);
            doSort(numbers, left, index - 1, myComparator);
            doSort(numbers, index + 1, right, myComparator);
        }
    }

    private int partition(int[] numbers, int left, int right, MyComparator myComparator) {
        int pivot = numbers[left];
        int pivotIndex = left;
        while (left < right) {
            while (left < right && myComparator.compare(numbers[right] + "", pivot + "") >= 0 ) {
                right -- ;
            }
            while (left < right && myComparator.compare(numbers[left] + "", pivot + "") <= 0) {
                left ++;
            }
            if (left < right) {
                swap(numbers, left, right);
            }
        }
        numbers[pivotIndex] = numbers[left];
        numbers[left] = pivot;
        return left;
    }

    private void swap(int[] numbers, int left, int right) {
        numbers[right] = numbers[left] ^ numbers[right];
        numbers[left] = numbers[left] ^ numbers[right];
        numbers[right] = numbers[left] ^ numbers[right];
    }

    public static void main(String[] args) {
        int[] arr = new int[] {3,32,321};
        String s = new PrintMinNumber().PrintMinNumber(arr);
        System.out.println(s);
    }

}
