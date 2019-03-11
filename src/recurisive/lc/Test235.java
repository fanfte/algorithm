package recurisive.lc;

/**
 * Created by tianen on 2019/2/8
 *
 * @author fanfte
 * @date 2019/2/8
 **/
public class Test235 {
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode res = null;
        if (p == null || q == null) {
            return null;
        }
        if (root == null) {
            return null;
        }
        if (root.val == p.val) {
            return p;
        }
        if (root.val == q.val) {
            return q;
        }
        if (p.val > root.val && q.val > root.val) {
            res = lowestCommonAncestor(root.right, p, q);
        }
        if (p.val < root.val && q.val < root.val) {
            res = lowestCommonAncestor(root.left, p, q);
        }
        if ((p.val < root.val && q.val > root.val) || (p.val > root.val && q.val < root.val)) {
            return root;
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        TreeUtils.preOrderOfTree(root);

        lowestCommonAncestor(root, new TreeNode(2), new TreeNode(4));
    }


}
