package recurisive.lc;

import recurisive.lc.TreeNode;

/**
 * Created by tianen on 2019/2/8
 *
 * @author fanfte
 * @date 2019/2/8
 **/
public class TreeUtils {

    public static void preOrderOfTree(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.val + " ");
        preOrderOfTree(node.left);
        preOrderOfTree(node.right);
    }
}
