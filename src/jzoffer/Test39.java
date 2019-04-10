package jzoffer;

import jzoffer.datastruct.TreeNode;

/**
 * Created by tianen on 2019/4/9
 *
 * @author fanfte
 * @date 2019/4/9
 **/
public class Test39 {

    public int depthOfBinaryTree(TreeNode node ) {
        if (node == null) {
            return 0;
        }
        int left = depthOfBinaryTree(node.left);
        int right = depthOfBinaryTree(node.right);
        return (left > right) ? left + 1 : right + 1;
    }

    public boolean isBalanced(TreeNode node) {
        int[] depth = new int[1];
        return checkBalanced(node, depth);
    }

    private boolean checkBalanced(TreeNode node, int[] depth) {
        if (node == null) {
            depth[0] = 0;
            return true;
        }
        int[] left = new int[1];
        int[] right = new int[1];
        if (checkBalanced(node.left, left) && checkBalanced(node.right, right)) {
            int diff = left[0] - right[0];
            if (diff >= -1 && diff <= 1) {
                depth[0] = 1 + (left[0] > right[0] ? left[0] : right[0]);
                return true;
            }
        }
        return false;
    }
}
