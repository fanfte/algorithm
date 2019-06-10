package test;

import jzoffer.datastruct.TreeNode;

/**
 * Created by tianen on 2019/6/1
 *
 * @author fanfte
 * @date 2019/6/1
 **/
public class IsSymmetrical {

    boolean isSymmetrical(TreeNode pRoot)
    {
        if (pRoot == null) {
            return true;
        }
        return doIsSymmetrical(pRoot.left, pRoot.right);
    }

    private boolean doIsSymmetrical(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left != null && right != null) {
            return left.value == right.value && doIsSymmetrical(left.left, right.right) && doIsSymmetrical(left.right, right.left);
        }
        return false;
    }
}
