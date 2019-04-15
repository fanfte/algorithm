package jzoffer;

/**
 * Created by tianen on 2019/4/2
 *
 * @author fanfte
 * @date 2019/4/2
 **/
public class Test29 {

    public int moreThanHalfNum(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Nums must contain nums.");
        }

        int left = 0;
        int right = nums.length - 1;
        int middle = nums.length >> 1;
        int index = partition(nums, left, right);
        while (index != middle) {
            if (index > middle) {
                right = middle - 1;
                index = partition(nums, left, right);
            } else {
                left = middle + 1;
                index = partition(nums, left, right);
            }
        }
        return nums[index];
    }

    private int partition(int[] nums, int left, int right) {
        int pivotIndex = left;
        int pivot = nums[left];

        int low = left;
        int high = right;
        while(low < high) {
            while(low < high && pivot < nums[low]) {
                low ++;
            }
            while(low < high && pivot > nums[high]) {
                high --;
            }
            if (low < high) {
                swap(nums, low, high);
            }
        }
        swap(nums, low, pivotIndex);
        return low;
    }

    private void swap(int[] nums, int low, int high) {
        int temp = nums[high];
        nums[high] = nums[low];
        nums[low] = temp;
    }

    public int moreThanHalf2(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Nums must not be empty.");
        }
        int result = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i ++) {
            if (nums[i] == result) {
                count ++;
            }else if (count == 0) {
                result = nums[i];
                count = 1;
            } else {
                count --;
            }
        }
        if (count >= nums.length / 2) {
            return result;
        } else {
            throw new IllegalArgumentException("Invalid input.");
        }
    }
}
