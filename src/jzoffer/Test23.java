package jzoffer;

import jzoffer.datastruct.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

import static javafx.scene.input.KeyCode.Q;

/**
 * Created by tianen on 2019/3/27
 *
 * @author fanfte
 * @date 2019/3/27
 **/
public class Test23 {

    public static void printFromTopToBottom(TreeNode node) {
        if (node == null) {
            return;
        }
        Queue<TreeNode> q = new LinkedList<>();

        q.add(node);
        while(!q.isEmpty()) {
            TreeNode e = q.poll();
            System.out.print(e.value + " ");
            if (e.left != null) {
                q.add(e.left);
            }
            if (e.right != null) {
                q.add(e.right);
            }
        }
    }

    public static void main(String[] args) {
        //       8
        //    /    \
        //   6     10
        //  / \   / \
        // 5   7 9  11
        TreeNode root = new TreeNode();
        root.value = 8;
        root.left = new TreeNode();
        root.left.value = 6;
        root.left.left = new TreeNode();
        root.left.left.value = 5;
        root.left.right = new TreeNode();
        root.left.right.value = 7;
        root.right = new TreeNode();
        root.right.value = 10;
        root.right.left = new TreeNode();
        root.right.left.value = 9;
        root.right.right = new TreeNode();
        root.right.right.value = 11;
        printFromTopToBottom(root);
        //         1
        //        /
        //       3
        //      /
        //     5
        //    /
        //   7
        //  /
        // 9
        TreeNode root2 = new TreeNode();
        root2.value = 1;
        root2.left = new TreeNode();
        root2.left.value = 3;
        root2.left.left = new TreeNode();
        root2.left.left.value = 5;
        root2.left.left.left = new TreeNode();
        root2.left.left.left.value = 7;
        root2.left.left.left.left = new TreeNode();
        root2.left.left.left.left.value = 9;
        System.out.println("\n");
        printFromTopToBottom(root2);
        // 0
        //  \
        //   2
        //    \
        //     4
        //      \
        //       6
        //        \
        //         8
        TreeNode root3 = new TreeNode();
        root3.value = 0;
        root3.right = new TreeNode();
        root3.right.value = 2;
        root3.right.right = new TreeNode();
        root3.right.right.value = 4;
        root3.right.right.right = new TreeNode();
        root3.right.right.right.value = 6;
        root3.right.right.right.right = new TreeNode();
        root3.right.right.right.right.value = 8;
        System.out.println("\n");
        printFromTopToBottom(root3);
        // 1
        TreeNode root4 = new TreeNode();
        root4.value = 1;
        System.out.println("\n");
        printFromTopToBottom(root4);
        // null
        System.out.println("\n");
        printFromTopToBottom(null);
    }
}
