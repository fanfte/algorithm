package test;

/**
 * Created by tianen on 2019/5/23
 *
 * @author fanfte
 * @date 2019/5/23
 **/
public class TestSort {

    public static void bubbleSort(int[] arr) {

        if (arr == null || arr.length == 0) {
            return ;
        }
        for (int i = 0; i < arr.length; i ++) {
            boolean changed = false;
            for (int j = 0; j < arr.length - i - 1; j ++) {
                if (arr[j + 1] < arr[j]) {
                    swap(arr, j, j + 1);
                    changed = true;
                }
            }
            if (!changed) {
                break;
            }
        }
    }

    public static void insertSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        for (int i = 1; i < arr.length; i ++) {
            int j = i - 1;
            for (; j > 0; j --) {
                if (arr[i] < arr[j]) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = arr[i];
        }
    }

    public static void quickSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        doSort(arr, 0, arr.length - 1);
    }

    private static void doSort(int[] arr, int start, int end) {
        if (start < end) {
            int index = partition(arr, start, end);
            doSort(arr, start, index - 1);
            doSort(arr, index + 1, end);
        }
    }

    public static int partition(int[] arr, int start, int end) {
        int pivot = arr[start];
        int pivotIndex = start;
        while (start < end) {
            while (start < end && arr[end] >= pivot) {
                end --;
            }
            while (start < end && arr[start] <= pivot) {
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

    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int[] temp = new int[arr.length];
        doMergeSort(arr, 0, arr.length - 1, temp);
    }

    private static void doMergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = left + ((right - left) >> 1);
            doMergeSort(arr, left, mid, temp);
            doMergeSort(arr, mid + 1, right, temp);
            merge(arr, left, mid, right, temp);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int index = 0;
        int s1 = left;
        int s2 = mid + 1;
        while (s1 <= mid && s2 <= right) {
            if (arr[s1] < arr[s2]) {
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
        int i = 0;
        while (left <= right) {
            arr[left ++] = temp[i ++];
        }
    }

    public static void heapSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        for (int i = (arr.length - 1) / 2; i >= 0; i --) {
            heapnify(arr, arr.length, i);
        }
        for (int i = arr.length - 1; i > 0; i --) {
            swap(arr, i, 0);
            heapnify(arr, i, 0);
        }
    }

    private static void heapnify(int[] arr, int length, int index) {
        int maxPos = index;
        while (maxPos < length) {
            if (index * 2 + 1 < length && arr[index * 2 + 1] > arr[index]) {
                maxPos = index * 2 + 1;
            }
            if (index * 2 + 2 < length && arr[index * 2 + 2] > arr[index] && arr[index * 2 + 2] > arr[index * 2 + 1]) {
                maxPos = index * 2 + 2;
            }
            if (maxPos == index) break;
            swap(arr, maxPos, index);
            index = maxPos;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
    }

    public static void main(String[] args) {
        int[] arr = new int[] {4, 5, 3, 9, 1, 6, 7, 8, 10};
//        bubbleSort(arr);
//        insertSort(arr);
//        quickSort(arr);
//        mergeSort(arr);
        heapSort(arr);
        printArray(arr);
    }

    private static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }


}
