package leetcode.tree;

import jzoffer.datastruct.TreeNode;

/**
 * Created by tianen on 2019/6/24
 *
 * @author fanfte
 * @date 2019/6/24
 **/
public class Test236 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == root) {
            return root;
        }
        if (p.value < root.value && q.value< root.value) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if (p.value > root.value && q.value > root.value) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }
}
