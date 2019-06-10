package test;

import jzoffer.datastruct.TreeNode;

/**
 * Created by tianen on 2019/6/10
 *
 * @author fanfte
 * @date 2019/6/10
 **/
public class ConvertTreeToList {

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        TreeNode[] lastNode = new TreeNode[1];
        doConvert(pRootOfTree, lastNode);
        TreeNode head = lastNode[0];
        while (head != null && head.left != null) {
            head = head.left;
        }
        return head;
    }

    private void doConvert(TreeNode node, TreeNode[] lastNode) {
        if (node != null) {
            if (node.left != null) {
                doConvert(node.left, lastNode);
            }
            node.left = lastNode[0];
            if (lastNode[0] != null) {
                lastNode[0].right = node;
            }
            lastNode[0] = node;
            if (node.right != null) {
                doConvert(node.right, lastNode);
            }
        }
    }
}
