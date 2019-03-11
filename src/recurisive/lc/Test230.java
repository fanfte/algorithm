package recurisive.lc;

import java.util.Stack;

/**
 * Created by tianen on 2019/2/9
 *
 * @author fanfte
 * @date 2019/2/9
 **/
public class Test230 {

    public int kthSmallest(TreeNode root, int k) {
        int count = getSizeOfTree(root.left);
        if (k < count) {
            return kthSmallest(root.left, k);
        }
        if (k > count + 1) {
            return kthSmallest(root.right, k - 1 - count);
        }
        return root.val;
    }

    public int getSizeOfTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + getSizeOfTree(root.left) + getSizeOfTree(root.right);
    }

    private int times = 0;

    private int num = 0;
    public void helper(TreeNode node) {
        if (node.left != null) {
            helper(node.left);
        }
        times --;
        if (times == 0) {
            num = node.val;
            return;
        }
        if (node.right != null) {
            helper(node.right);
        }
    }

    public int kthSmallest3(TreeNode node, int k) {
        Stack<TreeNode> st = new Stack<>();
        while (node != null) {
            st.push(node);
            node = node.left;
        }

        while (k != 0) {
            TreeNode n = st.pop();
            k --;
            if (k == 0) {
                return n.val;
            }
            TreeNode right = n.right;
            while (right != null) {
                st.push(right);
                right = right.left;
            }
        }
        return -1;
    }
}
