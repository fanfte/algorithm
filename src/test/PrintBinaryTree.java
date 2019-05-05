package test;

import jzoffer.datastruct.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by tianen on 2019/4/19
 *
 * @author fanfte
 * @date 2019/4/19
 **/
public class PrintBinaryTree {

    public static void printNode(TreeNode node) {
        if (node == null) {
            return;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(node);
        while(!q.isEmpty()) {
            TreeNode poll = q.poll();
            System.out.print(poll.value + " ");
            if (poll.left != null) {
                q.add(poll.left);
            }
            if (poll.right != null) {
                q.add(poll.right);
            }
        }
    }

    public static int depthOfNode(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftDepth = depthOfNode(node.left);
        int rightDepth = depthOfNode(node.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        printNode(root);
        System.out.println();
        System.out.println(depthOfNode(root));
    }
}
