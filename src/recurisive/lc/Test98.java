package recurisive.lc;

/**
 * Created by tianen on 2019/2/8
 *
 * @author fanfte
 * @date 2019/2/8
 **/
public class Test98 {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isValidBST(root.left, null, root.val)
                && isValidBST(root.right, root.val, null);
    }

    public boolean isValidBST(TreeNode node, Integer min, Integer max) {
        if (node == null) {
            return true;
        }
        if ((min != null && min >= node.val) || (max != null && max <= node.val)) {
            return false;
        }
        return isValidBST(node.left, min, node.val) && isValidBST(node.right, node.val, max);
    }

    public boolean isLeftNode(TreeNode node, TreeNode left) {
        if (left == null) {
            return true;
        }
        if (node.val <= left.val) {
            return false;
        }
        return isLeftNode(left, left.left);
    }

    public boolean isRigheNode(TreeNode node, TreeNode right) {
        if (right == null) {
            return true;
        }
        if (node.val >= right.val) {
            return false;
        }
        return isRigheNode(right, right.right);
    }


}
