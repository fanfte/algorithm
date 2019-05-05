package sort;

/**
 * Created by tianen on 2019/4/16
 *
 * @author fanfte
 * @date 2019/4/16
 **/
public class BubbleSort {

    public void sort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        for (int i = 0; i < arr.length; i ++) {
            boolean changed = false;
            for (int j = 0; j < arr.length - 1 - i; j ++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    changed = true;
                }
            }
            if (!changed) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] {8, 7, 5, 9, 4, 3, 1, 6};
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(arr);
        SortUtil.printArr(arr);
    }
}
