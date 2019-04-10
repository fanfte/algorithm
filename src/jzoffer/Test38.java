package jzoffer;

/**
 * Created by tianen on 2019/4/9
 *
 * @author fanfte
 * @date 2019/4/9
 **/
public class Test38 {

    public int getNumOfK(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int firstK = getFirstK(arr, k, 0, arr.length - 1);
        int lastK = getLastK(arr, k, 0, arr.length - 1);
        if (firstK > 0 && lastK > 0) {
            return lastK - firstK + 1;
        }
        return -1;
    }

    private int getLastK(int[] arr, int k, int left, int right) {
        if (arr == null || arr.length == 0 || left > right) {
            return -1;
        }
        int mid = left + (right - left) >> 1;
        if (k == arr[mid]) {
            if (mid + 1 < arr.length && arr[mid + 1] != k || mid == arr.length - 1) {
                return mid;
            } else {
                left = mid + 1;
            }
        } else if (k < arr[mid]) {
            right = mid - 1;
        } else {
            left = mid + 1;
        }
        return getLastK(arr, k, left, right);
    }

    private int getFirstK(int[] arr, int k, int left, int right) {
        if (arr == null || arr.length == 0 || left > right) {
            return -1;
        }
        int mid = left + (right - left) >> 1;
        if (arr[mid] == k) {
            if (mid > 0 && arr[mid - 1] != k || mid == 0) {
                return mid;
            } else {
                right = mid - 1;
            }
        } else if (arr[mid] < k){
            left = mid + 1;
        } else {
            right = mid - 1;
        }
        return getFirstK(arr, k, left, right);
    }
}
