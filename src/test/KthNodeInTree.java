package test;

import jzoffer.datastruct.TreeNode;

import java.util.Stack;

/**
 * Created by tianen on 2019/5/5
 *
 * @author fanfte
 * @date 2019/5/5
 **/
public class KthNodeInTree {

    TreeNode KthNode(TreeNode pRoot, int k)
    {
        if (pRoot == null || k <= 0) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = pRoot;
        int index = 0;
        while (!stack.isEmpty() || node != null) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                index ++;
                node = stack.pop();
                if (index == k) {
                    return node;
                }
                node = node.right;
            }
        }
        return node;
    }
}
