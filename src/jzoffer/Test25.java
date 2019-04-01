package jzoffer;

import jzoffer.datastruct.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tianen on 2019/4/1
 *
 * @author fanfte
 * @date 2019/4/1
 **/
public class Test25 {

    public static void findPath(TreeNode node, Integer aim) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        if (node != null) {
            findInTree(node, temp, result, aim);
        }
        for (List<Integer> integers : result) {
            System.out.println(integers);
        }
    }

    private static void findInTree(TreeNode node, List<Integer> temp, List<List<Integer>> result, Integer aim) {
        if (node == null) {
            return;
        }
        if (aim == node.value && node.left == null && node.right == null) {
            temp.add(aim);
            result.add(new ArrayList<>(temp));
            return;
        }
        if (node.left == null && node.right == null) {
            return;
        }
        temp.add(node.value);
        findInTree(node.left, temp, result, aim - node.value);
        findInTree(node.right, temp, result, aim - node.value);
        temp.remove(temp.size() - 1);
    }

    public static void main(String[] args) {
        //            10
        //         /      \
        //        5        12
        //       /\
        //      4  7
        TreeNode root = new TreeNode();
        root.value = 10;
        root.left = new TreeNode();
        root.left.value = 5;
        root.left.left = new TreeNode();
        root.left.left.value = 4;
        root.left.right = new TreeNode();
        root.left.right.value = 7;
        root.right = new TreeNode();
        root.right.value = 12;
        // 有两条路径上的结点和为22
        System.out.println("findPath(root, 22);");
        findPath(root, 22);
        // 没有路径上的结点和为15
        System.out.println("findPath(root, 15);");
        findPath(root, 15);
        // 有一条路径上的结点和为19
        System.out.println("findPath(root, 19);");
        findPath(root, 19);
        //               5
        //              /
        //             4
        //            /
        //           3
        //          /
        //         2
        //        /
        //       1
        TreeNode root2 = new TreeNode();
        root2.value = 5;
        root2.left = new TreeNode();
        root2.left.value = 4;
        root2.left.left = new TreeNode();
        root2.left.left.value = 3;
        root2.left.left.left = new TreeNode();
        root2.left.left.left.value = 2;
        root2.left.left.left.left = new TreeNode();
        root2.left.left.left.left.value = 1;
        // 有一条路径上面的结点和为15
        System.out.println("findPath(root2, 15);");
        findPath(root2, 15);
        // 没有路径上面的结点和为16
        System.out.println("findPath(root2, 16);");
        findPath(root2, 16);
        // 1
        //  \
        //   2
        //    \
        //     3
        //      \
        //       4
        //        \
        //         5
        TreeNode root3 = new TreeNode();
        root3.value = 1;
        root3.right = new TreeNode();
        root3.right.value = 2;
        root3.right.right = new TreeNode();
        root3.right.right.value = 3;
        root3.right.right.right = new TreeNode();
        root3.right.right.right.value = 4;
        root3.right.right.right.right = new TreeNode();
        root3.right.right.right.right.value = 5;
        // 有一条路径上面的结点和为15
        System.out.println("findPath(root3, 15);");
        findPath(root3, 15);
        // 没有路径上面的结点和为16
        System.out.println("findPath(root3, 16);");
        findPath(root3, 16);
        // 树中只有1个结点
        TreeNode root4 = new TreeNode();
        root4.value = 1;
        // 有一条路径上面的结点和为1
        System.out.println("findPath(root4, 1);");
        findPath(root4, 1);
        // 没有路径上面的结点和为2
        System.out.println("findPath(root4, 2);");
        findPath(root4, 2);
        // 树中没有结点
        System.out.println("findPath(null, 0);");
        findPath(null, 0);
    }
}
