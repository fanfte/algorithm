package jzoffer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tianen on 2019/4/4
 *
 * @author fanfte
 * @date 2019/4/4
 **/
public class Test30_Heap {

    public static class MaxHeap<T extends Comparable<T>> {
        private List<T> items;

        private int cursor = -1;

        public MaxHeap() {

        }

        public MaxHeap(int capacity) {
            items = new ArrayList<>(capacity);
        }

        public int getSize() {
            return items.size();
        }

        public boolean hasNext() {
            return cursor < items.size() - 1;
        }

        public T next() throws Exception {
            if (items == null || items.size() == 0 || cursor == items.size()) {
                throw new Exception("No element.");
            }
            cursor++;
            return items.get(cursor);
        }

        public void add(T e) {
            items.add(e);
            siftUp(items.size() - 1);
        }

        public T first() throws Exception {
            if (items == null || items.size() == 0) {
                throw new Exception("No element.");
            }
            return items.get(0);
        }

        public void siftUp(int index) {
            T aim = items.get(index);
            while (index > 0) {
                int parentIndex = (index - 1) >> 1;
                if (items.get(parentIndex).compareTo(aim) < 0) {
                    items.set(index, items.get(parentIndex));
                    index = parentIndex;
                } else {
                    break;
                }
            }
            items.set(index, aim);
        }

        private void siftDown(int index) throws Exception {
            if (items == null || items.size() == 0) {
                throw new Exception("No elements.");
            }
            T top = items.get(index);
            int leftIndex = (index << 1) + 1;
            while (leftIndex < items.size()) {
                T max = items.get(leftIndex);
                int maxIndex = leftIndex;

                int rightIndex = maxIndex + 1;
                if (rightIndex < items.size()) {
                    if (items.get(rightIndex).compareTo(max) > 0) {
                        maxIndex = rightIndex;
                        max = items.get(rightIndex);
                    }
                }

                if (top.compareTo(max) < 0) {
                    items.set(index, max);
                    index = maxIndex;
                    leftIndex = (index << 1) + 1;
                } else {
                    break;
                }
            }
            items.set(index, top);
        }

        public T deleteFromTop() throws Exception {
            if (items == null || items.size() == 0) {
                throw new Exception("No element.");
            }

            T maxItem = items.get(0);
            T last = items.remove(items.size() - 1);
            if (items.isEmpty()) {
                return last;
            }
            items.set(0, last);
            siftDown(0);
            return maxItem;
        }
    }

    public static int[] getLeastKNums(int[] nums, int k) throws Exception {
        int[] result = new int[k];
        if (nums == null || nums.length == 0 || k < 0) {
            return null;
        }
        MaxHeap<Integer> heap = new MaxHeap<>(k);
        for (int num : nums) {
            if (heap.getSize() < k) {
                heap.add(num);
            } else {
                Integer first = heap.first();
                if (num < first) {
                    heap.deleteFromTop();
                    heap.add(num);
                }
            }
        }
        int index = 0;
        while (heap.hasNext()) {
            result[index++] = heap.next();
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        int[] nums = {3, 5, 6, 8, 1, 7, 10, 2, 0, -3};
        int[] leastKNums = getLeastKNums(nums, 3);
        for (int num : leastKNums) {
            System.out.println(num + " ");
        }
    }
}
