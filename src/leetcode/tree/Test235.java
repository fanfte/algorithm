package leetcode.tree;

import jzoffer.datastruct.TreeNode;

/**
 * Created by tianen on 2019/6/24
 *
 * @author fanfte
 * @date 2019/6/24
 **/
public class Test235 {

    /**
     * 在root 左子树和右子树中寻找p或q，返回
     * 如果left right 都不为null返回root  否则返回结果不为null一方结果
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == root) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return root;
    }
}
