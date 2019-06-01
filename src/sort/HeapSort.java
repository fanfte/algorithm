package sort;

/**
 * Created by tianen on 2019/4/24
 *
 * @author fanfte
 * @date 2019/4/24
 **/
public class HeapSort {

    public void heapSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        // (arr.length - 1) / 2 为最后一个非叶子节点的索引
        for (int i = (arr.length - 1) / 2; i >= 0; i --) {
            heapnify(arr, arr.length, i);
        }

        for (int i = arr.length - 1; i > 0; i --) {
            swap(arr, i, 0);
            heapnify(arr, i, 0);
        }
    }

    private void heapnify(int[] arr, int length, int index) {
        int maxPos = index;
        while (maxPos < length) {
            if (index * 2 + 1 < length && arr[index * 2 + 1] > arr[index]) {
                maxPos = index * 2 + 1;
            }
            if (index * 2 + 2 < length && arr[index * 2 + 2] > arr[index]) {
                maxPos = index * 2 + 2;
            }
            if (maxPos == index) break;
            swap(arr, maxPos, index);
            index = maxPos;
        }
    }

    private void swap(int[] arr, int maxPos, int index) {
        int temp = arr[maxPos];
        arr[maxPos] = arr[index];
        arr[index] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {4, 6, 3, 2, 1, 8, 9, 7};
        new HeapSort().heapSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
