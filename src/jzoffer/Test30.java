package jzoffer;

/**
 * Created by tianen on 2019/4/2
 *
 * @author fanfte
 * @date 2019/4/2
 **/
public class Test30 {
    public int[] getLeastKNums(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0) {
            return null;
        }
        int start = 0;
        int end = nums.length - 1;
        int index = partition(nums, start, end);
        while (index != k - 1) {
            if (index > k - 1) {
                end = index - 1;
                index = partition(nums, start, end);
            } else {
                start = index + 1;
                index = partition(nums, start, end);
            }
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i ++) {
            result[i] = nums[i];
        }
        return result;
    }

    private int partition(int[] nums, int start, int end) {
        int pivot = nums[start];
        int pivotIndex = start;

        int left = start;
        int right = end;
        while(left < right) {
            while (left < right && pivot < nums[left]) {
                left ++;
            }

            while (left < right && pivot > nums[right]) {
                right --;
            }
            swap(nums, left, right);
        }
        swap(nums, pivotIndex, left);
        return left;
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
