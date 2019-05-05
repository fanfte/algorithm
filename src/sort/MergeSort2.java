package sort;

/**
 * Created by tianen on 2019/4/16
 *
 * @author fanfte
 * @date 2019/4/16
 **/
public class MergeSort2 {

    public void sort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int[] temp = new int[arr.length];
        doSort(arr, 0, arr.length - 1, temp);
    }

    private void doSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            doSort(arr, left, mid, temp);
            doSort(arr, mid + 1, right, temp);
            merge(arr, left, mid, right, temp);
        }
    }

    private void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int s1 = left;
        int s2 = mid + 1;
        int index = 0;
        while(s1 <= mid && s2 <= right) {
            if (arr[s1] <= arr[s2] ) {
                temp[index ++] = arr[s1 ++];
            } else {
                temp[index ++] = arr[s2 ++];
            }
        }
        while (s1 <= mid) {
            temp[index ++] = arr[s1 ++];
        }
        while (s2 <= right) {
            temp[index ++] = arr[s2 ++];
        }
        index = 0;
        while (left <= right) {
            arr[left ++] = temp[index ++];
        }
    }

    public static void main(String[] args) {
        int[] array = new int[] {9, 6, 7, 3, 1, 2, 4, 5, 11};
        new MergeSort2().sort(array);
        SortUtil.printArr(array);
    }
}
