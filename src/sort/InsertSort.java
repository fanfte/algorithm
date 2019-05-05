package sort;

/**
 * Created by tianen on 2019/4/16
 *
 * @author fanfte
 * @date 2019/4/16
 **/
public class InsertSort {

    public static void sort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        for (int i = 1; i < arr.length; i ++) {
            int value = arr[i];
            int j = i - 1;
            for (; j >= 0; j --) {
                if (value < arr[j]) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = value;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] {9, 7, 1, 5, 4, 3, 2, 8};
        sort(arr);
        SortUtil.printArr(arr);
    }
}
