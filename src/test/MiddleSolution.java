package test;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by tianen on 2019/6/10
 *
 * @author fanfte
 * @date 2019/6/10
 **/
public class MiddleSolution {

    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(1, Comparator.reverseOrder());

    private int count = 0;
    public void Insert(Integer num) {
        count ++;
        // 偶数
        if ((count & 1) == 0) {
            // 元素比大顶堆中的最大元素小，需要把最大元素放到小顶堆里
            if (!maxHeap.isEmpty() && num < maxHeap.peek()) {
                maxHeap.offer(num);
                num = maxHeap.poll();
            }
            minHeap.offer(num);
        } else {
            if (!minHeap.isEmpty() && num > minHeap.peek()) {
                minHeap.offer(num);
                num = minHeap.poll();
            }
            maxHeap.offer(num);
        }
    }

    public Double GetMedian() {
        double res;
        if (count == 0) {
            throw new RuntimeException("no available number!");
        }
        if ((count & 1) == 1) {
            res = maxHeap.peek();
        } else {
            res = (minHeap.peek() + maxHeap.peek()) / 2.0;
        }
        return res;
    }
}
