package recurisive.lc;

/**
 * Created by tianen on 2019/2/6
 *
 * @author fanfte
 * @date 2019/2/6
 **/
public class Test110 {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);

        return Math.abs(leftDepth - rightDepth) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    public int getDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftDepth = getDepth(node.left);
        int rightDepth = getDepth(node.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
