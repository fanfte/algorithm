package jzoffer;

/**
 * Created by tianen on 2019/3/21
 *
 * @author fanfte
 * @date 2019/3/21
 **/
public class Test07 {

    public int findMini(int[] arr) throws Exception {
        if (arr == null || arr.length == 0) {
            throw new Exception("Invalid parameters.");
        }

        int low = 0;
        int high = arr.length - 1;
        int middle = low;
        while(arr[low] >= arr[high]) {
            if (high - low == 1) {
                middle = high;
                break;
            }
            middle = low + (high - low) / 2;
            if (arr[low] == arr[middle] && arr[middle] == arr[high]) {
                return findInOrder(arr, low, high);
            }
            if (arr[middle] >= arr[low]) {
                low = middle;
            } else {
                high = middle;
            }
        }
        return arr[middle];
    }

    private int findInOrder(int[] arr, int low, int high) {
        int result = arr[low];
        for (int i = low + 1; i <= high; i ++) {
            if (result > arr[i]) {
                result = arr[i];
            }
        }
        return result;
    }
}
