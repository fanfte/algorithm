package search;

/**
 * Created by tianen on 2019/4/9
 *
 * @author fanfte
 * @date 2019/4/9
 **/
public class BinarySearch {

    public int binarySearch(int[] arr, int aim, int start, int end) {
        int mid = start + (end - start) >> 1;
        if (arr[mid] == aim) {
            return mid;
        } else if (arr[mid] < aim) {
            start = mid + 1;
            binarySearch(arr, aim, start, end);
        } else {
            end = mid - 1;
            binarySearch(arr, aim, start, end);
        }
        return -1;
    }

    public int binarySearch(int[] arr, int aim) {
        int start = 0;
        int end = arr.length - 1;
        int mid = start + (end - start) >> 1;
        if (aim == arr[mid]) {
            return mid;
        }
        while (start <= end) {
            mid = (end - start) >> 1 + start;
            if (aim < arr[mid]) {
                end = mid - 1;
            } else if (aim > arr[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
