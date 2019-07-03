package leetcode.tree;

import jzoffer.datastruct.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tianen on 2019/6/24
 *
 * @author fanfte
 * @date 2019/6/24
 **/
public class Test98 {
    /**
     * 使用中序遍历，保存前一个节点的值，判断是否升序序列
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }
        List<Integer> list = new ArrayList<>();
        return inOrder(root, list);
    }

    private boolean inOrder(TreeNode root, List<Integer> pre) {
        if (root == null) {
            return true;
        }
        boolean left = inOrder(root.left, pre);
        boolean mid = true;
        if (pre.size() == 0) {
            pre.add(root.value);
        } else {
            mid = pre.get(0) < root.value;
            pre.set(0, root.value);
        }
        return left && mid && inOrder(root.right, pre);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        System.out.println(new Test98().isValidBST(root));
    }

    /**
     * 递归，取左子树的最大值max，右子树的最小值min
     * root.val > max && root.val < min
     */
    public boolean isValidBST2(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }
        return valid(root, null, null);
    }

    private boolean valid(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }
        if (min != null && root.value <= min) {
            return false;
        }
        if (max != null && root.value >= max) {
            return false;
        }
        return valid(root.left, min, root.value) && valid(root.right, root.value, max);
    }
}
