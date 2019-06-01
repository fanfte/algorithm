package test;

import jzoffer.datastruct.ListNode;

import java.util.ArrayList;

/**
 * Created by tianen on 2019/5/14
 *
 * @author fanfte
 * @date 2019/5/14
 **/
public class ContinuousSequence {

    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (sum <= 0) {
            return result;
        }
        int left = 1, right = 2;
        while (left < right) {
            int tempSum = (left + right) * (right - left + 1) / 2;
            if (tempSum < sum) {
                right ++;
            } else if (tempSum > sum){
                left ++;
            } else {
                ArrayList<Integer> res = new ArrayList<>();
                for (int i = left; i <= right;i ++) {
                    res.add(i);
                }
                result.add(res);
                left ++;
            }
        }
        return result;
    }

    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> result = new ArrayList<>();
        if(array == null || array.length == 0) {
            return result;
        }
        int left = 0;
        int right = array.length - 1;
        int mulRes = Integer.MAX_VALUE;
        while (left < right) {
            int tempSum = array[left] + array[right];
            if (tempSum == sum) {
                if (array[left] * array[right] < mulRes) {
                    result.add(array[left]);
                    result.add(array[right]);
                    mulRes = array[left] * array[right];
                }
                left ++;
            } else if(tempSum < sum){
                left ++;
            } else {
                right --;
            }
        }
        return result;
    }

    public int GetNumberOfK(int [] array , int k) {
        if (array == null || array.length == 0) {
            return 0;
        }

        int firstIndex = findFirst(array, k);
        int lastIndex = findLast(array, k);
        if (firstIndex != -1 && lastIndex != -1 && lastIndex > firstIndex) {
            return lastIndex - firstIndex + 1;
        }
        if (firstIndex != -1 && lastIndex != -1) {
            return 1;
        }
        return -1;
    }

    private int findLast(int[] array, int k) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (array[mid] > k) {
                right = mid - 1;
            } else if (array[mid] < k || (mid + 1 < array.length && array[mid + 1] == k)){
                left = mid + 1;
            } else {
                if (mid == array.length - 1 || array[mid + 1] != k) {
                    return mid;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }

    private int findFirst(int[] array, int k) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (array[mid] > k) {
                right = mid - 1;
            } else if (array[mid] < k){
                left = mid + 1;
            } else {
                if (mid == 0 || array[mid - 1] != k) {
                    return mid;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1,2,3,3,3,3,4,5};
        int i = new ContinuousSequence().GetNumberOfK(arr, 3);
        System.out.println(i);
    }

    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        if(pHead == null || pHead.next == null || pHead.next.next == null) {
            return null;
        }
        ListNode fast = pHead.next.next;
        ListNode slow = pHead.next;
        while (fast != slow) {
            if (fast.next == null || fast.next.next == null) {
                return null;
            } else {
                fast = fast.next.next;
                slow = slow.next;
            }
        }
        fast = pHead;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> result = new ArrayList<>();
        if (num == null || num.length == 0 || size <= 0) {
            return result;
        }

        for (int i = 0 ;i <= num.length - size; i ++) {
            int max = Integer.MIN_VALUE;
            for (int j = i; i < i + size; j ++) {
                if (num[j] > max) {
                    max = num[j];
                }
            }
            result.add(max);
        }
        return result;
    }
}
