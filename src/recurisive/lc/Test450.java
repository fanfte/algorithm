package recurisive.lc;

/**
 * Created by tianen on 2019/2/8
 *
 * @author fanfte
 * @date 2019/2/8
 **/
public class Test450 {

    public static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            if (root.right == null && root.left == null) {
                return null;
            }
            if (root.right != null && root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            TreeNode minNode = findMin(root.right);
            root.val = minNode.val;
            root.right = deleteNode(root.right, minNode.val);
            return root;
        }
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        }
        if (root.val < key) {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }

    private static TreeNode findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public static TreeNode deleteNode2(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.right == null && root.left == null) {
            return root;
        }
        if (root.val == key) {
            if (root.right.right == null && root.right.left == null) {
                root.right = null;
                return root;
            }
            if (root.right.right != null && root.right.left == null) {
                root.right.val = root.right.right.val;
                root.right.right = null;
                return root;
            }
            if (root.right.right == null ) {
                root.val = root.right.left.val;
                root.right.left = null;
                return root;
            }
            root.right.val = root.right.right.val;
            root.right.right = null;
            return root;
        }
        if (root.val > key) {
            deleteNode2(root.left, key);
        }
        if (root.val < key) {
            deleteNode2(root.right, key);
        }
        return root;
    }

    public void deleteNode(TreeNode node, TreeNode aim, int key) {
        if (aim == null) {
            return;
        }
        if (aim.val == key) {
            if (aim.right != null) {
                aim.val = aim.right.val;
            }
            if (aim.left != null) {
                aim.val = aim.left.val;
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(6);
        root.right.right = new TreeNode(7);

//        TreeNode root = new TreeNode(1);
//        root.left = null;
//        root.right = new TreeNode(2);
        TreeUtils.preOrderOfTree(root);
        System.out.println();
        TreeNode treeNode = deleteNode(root, 3);
        TreeUtils.preOrderOfTree(treeNode);
    }

}
