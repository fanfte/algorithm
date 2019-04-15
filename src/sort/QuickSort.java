package sort;

/**
 * Created by tianen on 2019/4/15
 *
 * @author fanfte
 * @date 2019/4/15
 **/
public class QuickSort {

    public void sort(int[] arr) {
        doSort(arr, 0, arr.length - 1);
    }

    private void doSort(int[] arr, int start, int end) {
        if (start < end) {
            int index = partition(arr, start, end);
            doSort(arr, start, index - 1);
            doSort(arr, index + 1, end);
        }
    }

    private int partition(int[] arr, int start, int end) {
        int pivot = arr[start];
        int pivotIndex = start;
        while(start < end) {
            while (start < end && pivot <= arr[end]) {
                end --;
            }
            while (start < end && pivot >= arr[start]) {
                start ++;
            }
            if (start < end) {
                swap(arr, start, end);
            }
        }
        arr[pivotIndex] = arr[start];
        arr[start] = pivot;
        return start;
    }

    private void swap(int[] arr, int start, int end) {
        int temp = arr[end];
        arr[end] = arr[start];
        arr[start] = temp;
    }

    public void printArr(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = {9, 6, 1, 3, 4, 5, 2, 8, 7};
        QuickSort quickSort = new QuickSort();
        quickSort.sort(arr);
        quickSort.printArr(arr);
    }
}
