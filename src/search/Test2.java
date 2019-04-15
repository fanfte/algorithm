package search;

import jzoffer.datastruct.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by tianen on 2019/4/11
 *
 * @author fanfte
 * @date 2019/4/11
 **/
public class Test2 {

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            TreeNode poll = q.poll();
            result.add(poll.value);
            if (poll.left != null) {
                q.add(poll.left);
            }
            if (poll.right != null) {
                q.add(poll.right);
            }
        }
        return result;
    }

    public void quickSort(int[] arr, int start, int end) {
        if (arr == null || arr.length == 0 || start >= end) {
            return;
        }
        int index = partition(arr, start, end);
        quickSort(arr, start, index - 1);
        quickSort(arr, index + 1, end);
    }

    public int partition(int[] arr, int start, int end) {
        int pivot = arr[start];
        int left = start;
        int right = end;

        while (left < right) {
            while (left < right && arr[right] >= pivot) {
                right --;
            }
            while (left < right && arr[left] <= pivot) {
                left ++;
            }
            if (left < right) {
                swap(arr, left, right);
            }
        }
        swap(arr, left, start);
        return left;
    }

    private void swap(int[] arr, int left, int right) {
        int temp = arr[right];
        arr[right] = arr[left];
        arr[left] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {3, 5, 1, 9, 6};
        new Test2().quickSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
