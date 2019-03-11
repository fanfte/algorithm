package recurisive.lc;

/**
 * Created by tianen on 2019/2/6
 *
 * @author fanfte
 * @date 2019/2/6
 **/
public class Test111 {


    public int minDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null) {
            return minDepth(node.right) + 1;
        }

        if (node.right == null) {
            return minDepth(node.left) + 1;
        }
        return Math.min(minDepth(node.left), minDepth(node.right)) + 1;
    }
}
