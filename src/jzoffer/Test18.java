package jzoffer;

import jzoffer.datastruct.TreeNode;

/**
 * Created by tianen on 2019/3/26
 *
 * @author fanfte
 * @date 2019/3/26
 **/
public class Test18 {

    public boolean hasSubTree(TreeNode node, TreeNode aim) {
        if (node == aim) {
            return true;
        }
        if (aim == null) {
            return true;
        }
        if (node == null) {
            return false;
        }
        boolean res = false;
        if (node.value == aim.value) {
            res = match(node, aim);
        }
        if (res) {
            return true;
        }
        return hasSubTree(node.left, aim) || hasSubTree(node.right, aim);
    }

    public boolean match(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 != null && node2 == null) {
            return true;
        }
        if (node1 == null && node2 != null) {
            return false;
        }
        if (node1.value == node2.value) {
            return match(node1.left, node2.left) && match(node1.right, node2.right);
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode();
        root1.value = 8;
        root1.right = new TreeNode();
        root1.right.value = 7;
        root1.left = new TreeNode();
        root1.left.value = 8;
        root1.left.left = new TreeNode();
        root1.left.left.value = 9;
        root1.left.right = new TreeNode();
        root1.left.right.value = 2;
        root1.left.right.left = new TreeNode();
        root1.left.right.left.left = new TreeNode();
        root1.left.right.left.left.value = 4;
        root1.left.right.left.right = new TreeNode();
        root1.left.right.left.right.value = 7;
        TreeNode root2 = new TreeNode();
        root2.value = 8;
        root2.left = new TreeNode();
        root2.left.value = 9;
        root2.right = new TreeNode();
        root2.right.value = 2;
        Test18 t = new Test18();
        System.out.println(t.hasSubTree(root1, root2));
        System.out.println(t.hasSubTree(root2, root1));
        System.out.println(t.hasSubTree(root1, root1.left));
        System.out.println(t.hasSubTree(root1, null));
        System.out.println(t.hasSubTree(null, root2));
        System.out.println(t.hasSubTree(null, null));
    }
}
