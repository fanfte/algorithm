package test;

import jzoffer.datastruct.TreeNode;

/**
 * Created by tianen on 2019/5/5
 *
 * @author fanfte
 * @date 2019/5/5
 **/
public class IsBalancedTree {

    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean[] result = new boolean[1];
        result[0] = true;
        int leftDepth = findDepth(root.left, 1, result);
        return result[0];
    }

    private int findDepth(TreeNode head, int level, boolean[] result) {
        if (head == null) {
            return level;
        }
        int leftDepth = findDepth(head.left, level + 1, result);
        if (!result[0]) {
            return level;
        }
        int rightDepth = findDepth(head.right, level + 1, result);
        if (!result[0]) {
            return level;
        }
        if (Math.abs(leftDepth -  rightDepth) > 1) {
            result[0] = false;
        }
        return Math.max(leftDepth, rightDepth);
    }

    public boolean IsBalanced_Solution2(TreeNode root) {
        if (root == null) {
            return true;
        }

        return (Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1)
                && IsBalanced_Solution2(root.left) && IsBalanced_Solution2(root.right);
    }

    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public boolean IsBalanced_Solution3(TreeNode root) {
        return getDepth(root) != -1;
    }

    private int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lD = getDepth(root.left);
        if (lD == -1) return -1;
        int rD = getDepth(root.right);
        if (rD == -1) return -1;
        return Math.abs(lD - rD) > 1 ? -1 : 1 + Math.max(lD, rD);
    }
}
