package recurisive.lc;

/**
 * Created by tianen on 2019/2/6
 *
 * @author fanfte
 * @date 2019/2/6
 **/
public class Test404 {

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        } else if(isLeaf(root.left)) {
            return root.left.val + sumOfLeftLeaves(root.right);
        } else {
            return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
        }
    }

    private boolean isLeaf(TreeNode node) {
        if (node == null) {
            return false;
        }

        if(node.left == null && node.right == null) {
            return true;
        }
        return false;
    }

}
