package leetcode.stackandqueue;

import java.util.PriorityQueue;

/**
 * Created by tianen on 2019/6/23
 *
 * @author fanfte
 * @date 2019/6/23
 **/
public class Test703 {
    class KthLargest {
        private PriorityQueue<Integer> queue;
        private int size;
        public KthLargest(int k, int[] nums) {
            queue = new PriorityQueue(k);
            size = k;
            for (int num : nums) {
                add(num);
            }
        }

        public int add(int val) {
            if (queue.size() < size) {
                queue.offer(val);
            } else if (queue.peek() < val){
                queue.poll();
                queue.offer(val);
            }
            return queue.peek();
        }
    }
}
