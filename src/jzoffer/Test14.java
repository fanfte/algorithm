package jzoffer;

/**
 * Created by tianen on 2019/3/26
 *
 * @author fanfte
 * @date 2019/3/26
 **/
public class Test14 {

    public void reOrderOddEven(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }

        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            while (start < end && arr[start] % 2 != 0) {
                start ++;
            }
            while (start < end && arr[end] % 2 == 0) {
                end --;
            }
            swap(arr, start, end);
        }
    }

    public void printArr(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    private void swap(int[] arr, int start, int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {3, 6, 4, 7, 1, 8, 9, 6};
        Test14 t = new Test14();
        t.printArr(arr);
        t.reOrderOddEven(arr);
        t.printArr(arr);
    }


}
