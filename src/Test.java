import jzoffer.datastruct.ListNode;
import jzoffer.datastruct.TreeNode;

import java.util.*;

/**
 * Created by tianen on 2019/4/11
 *
 * @author fanfte
 * @date 2019/4/11
 **/
public class Test {

    public void Mirror(TreeNode root) {
        TreeNode node = mirrorOfTree(root);
        root = node;
    }

    private TreeNode mirrorOfTree(TreeNode node) {
        if (node == null) {
            return null;
        }
        TreeNode left = mirrorOfTree(node.left);
        TreeNode right = mirrorOfTree(node.right);
        node.left = right;
        node.right = left;
        return node;
    }


    public ListNode Merge(ListNode head1, ListNode head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        ListNode head = (head1.value <= head2.value) ? head1 : head2;
        ListNode cur1 = head == head1 ? head1 : head2;
        ListNode cur2 = head == head1 ? head2 : head1;
        while (cur1 != null && cur2 != null) {
            if (cur1.value <= cur2.value) {
                head.next = cur1;
                cur1 = cur1.next;
            } else {
                head.next = cur2;
                cur2 = cur2.next;
            }
        }
        if (cur1 == null) {
            head.next = cur2;
        } else {
            head.next = cur1;
        }
        return head;
    }

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if (input == null || input.length == 0) {
            return res;
        }
        if (input.length < k) {
            return res;
        }
        PriorityQueue<Integer> q = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });

        for(int i = 0; i < input.length; i ++) {
            if (q.size() < k) {
                q.offer(input[i]);
            } else if (q.peek() > input[i]) {
                q.poll();
                q.offer(input[i]);
            }
        }
        while (!q.isEmpty()) {
            res.add(q.poll());
        }
        return res;
    }

    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence == null || sequence.length == 0) {
            return false;
        }
        return verif(sequence, 0, sequence.length - 1);
    }

    private boolean verif(int[] sequence, int start, int end) {
        if(sequence == null || sequence.length == 0) {
            return false;
        }
        if (start >= end) {
            return true;
        }
        int root = sequence[end];
        int i = 0;
        while(i < end - 1) {
            if (sequence[i] < root) {
                i ++;
            } else {
                break;
            }
        }
        int j = i;
        while (j < end - 1) {
            if (sequence[j] > root) {
                j ++;
            } else {
                return false;
            }
        }
        if (j != end - 1) {
            return false;
        }
        return verif(sequence, start, i - 1) && verif(sequence, i, end - 1);
    }

    public int MoreThanHalfNum_Solution(int [] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int left = 0;
        int right = array.length - 1;
        int middle = right >> 1;
        int index = partition(array, left, right);
        while(index != middle) {
            if (index < middle) {
                left  = index + 1;
                index = partition(array, left, right);
            } else {
                right = middle - 1;
                index = partition(array, left, right);
            }
        }
        int count = 0;
        for (int i = 0; i < index; i ++) {
            if (array[i] == array[middle]) {
                count++;
            }
        }
        return (count > array.length >> 1) ? array[index] : 0;
    }

    private int partition(int[] array, int start, int end) {
        int pivot = array[start];
        int pivotIndex = start;
        while (start < end) {
            while (start < end && array[end] >= pivot ) {
                end --;
            }
            while (start < end && array[start] <= pivot) {
                start ++;
            }
            if (start < end) {
                swap(array, start, end);
            }
        }
        array[pivotIndex] = array[start];
        array[start] = pivot;
        return start;
    }

    private void swap(int[] array, int start, int end) {
        int temp = array[end];
        array[end] = array[start];
        array[start] = temp;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public int binarySearch(int[] arr, int aim, int start, int end) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int middle = start + (end - start) >> 1;
        while (start < end) {
            if (arr[middle] == aim) {
                return middle;
            } else if(arr[middle] < aim) {
                start = middle + 1;
                binarySearch(arr, aim, start, end);
            } else {
                end = middle - 1;
                binarySearch(arr, aim, start, end);
            }
        }
        return -1;
    }

    public int binarySearch(int[] arr, int aim) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left) >> 1;
            if (arr[mid] == aim) {
                return mid;
            } else if(arr[mid] < aim) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
