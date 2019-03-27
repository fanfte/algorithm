package jzoffer;

import jzoffer.datastruct.TreeNode;

/**
 * Created by tianen on 2019/3/26
 *
 * @author fanfte
 * @date 2019/3/26
 **/
public class Test19 {

    public void mirror(TreeNode node) {
        if (node == null || (node.left == null && node.right == null)) {
            return;
        }
        TreeNode tmp = node.left;
        node.left = node.right;
        node.right = tmp;
        mirror(node.left);
        mirror(node.right);
    }
}
