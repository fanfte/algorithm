package leetcode.stackandqueue;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by tianen on 2019/6/23
 *
 * @author fanfte
 * @date 2019/6/23
 **/
public class Test239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) {
            return new int[0];
        }
        PriorityQueue<Integer> queue = new PriorityQueue(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        for (int i = 0; i < nums.length; i ++) {
            if (queue.size() < k) {
                queue.add(nums[i]);
                if (i == k - 1) {
                    res[index ++] = queue.peek();
                }
            } else {
                queue.remove(nums[i - k]);
                queue.offer(nums[i]);
                res[index ++] = queue.peek();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1, 3, -1, -3, 5, 3, 6, 7};
        int[] ints = new Test239().maxSlidingWindow(arr, 3);
        for (int anInt : ints) {
            System.out.print(anInt + " ");
        }
    }
}
