package jzoffer;

import jzoffer.datastruct.TreeNode;

/**
 * Created by tianen on 2019/4/2
 *
 * @author fanfte
 * @date 2019/4/2
 **/
public class Test27 {

    public static TreeNode convert(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode[] lastNode = new TreeNode[1];
        convertNode(root, lastNode);
        TreeNode node = lastNode[0];
        while (node != null && node.left != null) {
            node = node.left;
        }
        return node;
    }

    private static void convertNode(TreeNode root, TreeNode[] lastNode) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            convertNode(root.left, lastNode);
        }
        root.left = lastNode[0];
        if (lastNode[0] != null) {
            lastNode[0].right = root;
        }
        lastNode[0] = root;
        if (root.right != null) {
            convertNode(root.right, lastNode);
        }
    }

    public static void main(String[] args) {
        test01();
        test02();
        test03();
        test04();
        test05();
    }
    private static void printList(TreeNode head) {
        while (head != null) {
            System.out.print(head.value + "->");
            head = head.right;
        }
        System.out.println("null");
    }
    private static void printTree(TreeNode root) {
        if (root != null) {
            printTree(root.left);
            System.out.print(root.value + "->");
            printTree(root.right);
        }
    }
    //            10
    //         /      \
    //        6        14
    //       /\        /\
    //      4  8     12  16
    private static void test01() {
        TreeNode node10 = new TreeNode();
        node10.value = 10;
        TreeNode node6 = new TreeNode();
        node6.value = 6;
        TreeNode node14 = new TreeNode();
        node14.value = 14;
        TreeNode node4 = new TreeNode();
        node4.value = 4;
        TreeNode node8 = new TreeNode();
        node8.value = 8;
        TreeNode node12 = new TreeNode();
        node12.value = 12;
        TreeNode node16 = new TreeNode();
        node16.value = 16;
        node10.left = node6;
        node10.right = node14;
        node6.left = node4;
        node6.right = node8;
        node14.left = node12;
        node14.right = node16;
        System.out.print("Before convert: ");
        printTree(node10);
        System.out.println("null");
        TreeNode head = convert(node10);
        System.out.print("After convert : ");
        printList(head);
        System.out.println();
    }
    //               5
    //              /
    //             4
    //            /
    //           3
    //          /
    //         2
    //        /
    //       1
    private static void test02() {
        TreeNode node1 = new TreeNode();
        node1.value = 1;
        TreeNode node2 = new TreeNode();
        node2.value = 2;
        TreeNode node3 = new TreeNode();
        node3.value = 3;
        TreeNode node4 = new TreeNode();
        node4.value = 4;
        TreeNode node5 = new TreeNode();
        node5.value = 5;
        node5.left = node4;
        node4.left = node3;
        node3.left = node2;
        node2.left = node1;
        System.out.print("Before convert: ");
        printTree(node5);
        System.out.println("null");
        TreeNode head = convert(node5);
        System.out.print("After convert : ");
        printList(head);
        System.out.println();
    }
    // 1
    //  \
    //   2
    //    \
    //     3
    //      \
    //       4
    //        \
    //         5
    private static void test03() {
        TreeNode node1 = new TreeNode();
        node1.value = 1;
        TreeNode node2 = new TreeNode();
        node2.value = 2;
        TreeNode node3 = new TreeNode();
        node3.value = 3;
        TreeNode node4 = new TreeNode();
        node4.value = 4;
        TreeNode node5 = new TreeNode();
        node5.value = 5;
        node1.right = node2;
        node2.right = node3;
        node3.right = node4;
        node4.right = node5;
        System.out.print("Before convert: ");
        printTree(node1);
        System.out.println("null");
        TreeNode head = convert(node1);
        System.out.print("After convert : ");
        printList(head);
        System.out.println();
    }
    // 只有一个结点
    private static void test04() {
        TreeNode node1 = new TreeNode();
        node1.value = 1;
        System.out.print("Before convert: ");
        printTree(node1);
        System.out.println("null");
        TreeNode head = convert(node1);
        System.out.print("After convert : ");
        printList(head);
        System.out.println();
    }
    // 没有结点
    private static void test05() {
        System.out.print("Before convert: ");
        printTree(null);
        System.out.println("null");
        TreeNode head = convert(null);
        System.out.print("After convert : ");
        printList(head);
        System.out.println();
    }
}
