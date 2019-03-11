package recurisive.lc;

/**
 * Created by tianen on 2019/2/6
 *
 * @author fanfte
 * @date 2019/2/6
 **/
public class Test101 {

    public boolean isSymmetric(TreeNode root) {

        if (root == null) {
            return true;
        }
        return isSideSymmetric(root.left, root.right);
    }

    public boolean isSideSymmetric(TreeNode left, TreeNode right) {
        if (left == null || right == null) {
            return left == right;
        }

        if (left.val != right.val) {
            return false;
        }
        return isSideSymmetric(left.left, right.right) && isSideSymmetric(left.right, right.left);
    }
}
