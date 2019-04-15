package sort;

/**
 * Created by tianen on 2019/4/15
 *
 * @author fanfte
 * @date 2019/4/15
 **/
public class MergeSort {

    public void sort(int[] arr) {
        int[] temp = new int[arr.length];
        doSort(arr, 0, arr.length - 1, temp);
    }

    private void doSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = left + ((right - left) >> 1);
            doSort(arr, left, mid, temp);
            doSort(arr, mid + 1,  right, temp);
            merge(arr, left, mid, right, temp);
        }
    }

    private void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int s1 = left;
        int s2 = mid + 1;
        int start = 0;
        while (s1 <= mid && s2 <= right) {
            if (arr[s1] <= arr[s2]) {
                temp[start ++] = arr[s1 ++];
            } else {
                temp[start ++] = arr[s2 ++];
            }
        }
        while (s1 <= mid) {
            temp[start ++] = arr[s1 ++];
        }
        while (s2 <= right) {
            temp[start ++] = arr[s2 ++];
        }
        int i = 0;
        while (left <= right) {
            arr[left ++] = temp[i ++];
        }
    }

    public void printArr(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = new int[] {8, 3, 2, 6, 4, 1};
        MergeSort s = new MergeSort();
        s.sort(arr);
        s.printArr(arr);
    }
}
