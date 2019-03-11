package recurisive.lc;

/**
 * Created by tianen on 2019/2/6
 *
 * @author fanfte
 * @date 2019/2/6
 **/
public class Test226 {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode leftNode = invertTree(root.left);
        TreeNode rightNode = invertTree(root.right);
        root.left = rightNode;
        root.right = leftNode;
        return root;
    }
}
