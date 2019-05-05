package search;

/**
 * Created by tianen on 2019/4/17
 *
 * @author fanfte
 * @date 2019/4/17
 **/
public class BinarySearchChange {

    public int findFirstEqualTo(int[] array, int aim) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int left = 0;
        int right = array.length - 1;
        int index = -1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (array[mid] == aim) {
                index = mid;
                break;
            } else if (aim < array[mid] ) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        while(index > 0) {
            if (array[index - 1] == array[index]) {
                index --;
            } else {
                break;
            }
        }
        return index;
    }

    public int findLastEqualTo(int[] array, int aim) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int left = 0;
        int right = array.length - 1;
        while(left <= right) {
            int mid = left + ((right - left) >> 1);
            if (array[mid] < aim) {
                left = mid + 1;
            } else if (array[mid] > aim) {
                right = mid - 1;
            } else {
                if (mid == array.length - 1 || array[mid + 1] != aim) {
                    return mid;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1, 3, 4, 5, 6, 8, 8, 8, 11, 18};
        BinarySearchChange b = new BinarySearchChange();
        int index = b.findFirstEqualTo(arr, 8);
        System.out.println(index);
        index = b.findLastEqualTo(arr, 8);
        System.out.println(index);
    }
}
