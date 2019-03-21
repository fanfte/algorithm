package jzoffer;

/**
 * Created by tianen on 2019/3/21
 *
 * @author fanfte
 * @date 2019/3/21
 **/
public class Test06 {

    public static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    public static TreeNode construct(int[] preTree, int[] inTree) throws Exception {
        if (preTree == null || inTree == null || preTree.length == 0 || inTree.length == 0) {
            return null;
        }

        return construct(preTree, 0, preTree.length - 1, inTree, 0, inTree.length - 1);
    }

    private static TreeNode construct(int[] preTree, int preStart, int preEnd, int[] inTree, int inStart, int inEnd) throws Exception {
        if (preStart > preEnd) {
            return null;
        }
        if (inStart > inEnd) {
            return null;
        }

        int value = preTree[preStart];
        int index = inStart;
        while(index < inEnd && inTree[index] != value) {
            index ++;
        }
        if (index > inEnd) {
            throw new Exception("Invalid input.");
        }

        TreeNode node = new TreeNode(value);
        node.left = construct(preTree, preStart + 1, preStart + index - inStart, inTree, inStart, index - 1);
        node.right = construct(preTree, preStart + index - inStart + 1, preEnd, inTree, index + 1, inEnd);
        return node;
    }

    // 中序遍历二叉树
    public static void printTree(TreeNode root) {
        if (root != null) {
            printTree(root.left);
            System.out.print(root.value + " ");
            printTree(root.right);
        }
    }

    public static void main(String[] args) throws Exception {
        int[] preorder = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] inorder = {4, 7, 2, 1, 5, 3, 8, 6};
        TreeNode root = construct(preorder, inorder);
        printTree(root);
    }
}
