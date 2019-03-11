package dp;

import recurisive.lc.TreeNode;

import java.util.HashMap;

/**
 * Created by tianen on 2019/3/8
 *
 * @author fanfte
 * @date 2019/3/8
 **/
public class Test337 {

    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        if (root.left != null) {
            res += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            res += rob(root.right.left) + rob(root.right.right);
        }
        return Math.max(root.val + res, rob(root.left) + rob(root.right));
    }

    public int rob2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        if (root.left != null) {
            res += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            res += rob(root.right.left) + rob(root.right.right);
        }
        return Math.max(root.val + res, rob(root.left) + rob(root.right));
    }

    public int rob3(TreeNode root) {
        return tryRob(root, new HashMap<TreeNode, Integer>());
    }

    private int tryRob(TreeNode root, HashMap<TreeNode, Integer> map) {
        if (root == null) {
            return 0;
        }
        if (map.containsKey(root)) {
            return map.get(root);
        }
        int res = 0;
        if (root.left != null) {
            res += tryRob(root.left.left, map) + tryRob(root.left.right, map);
        }
        if (root.right != null) {
            res += tryRob(root.right.left, map) + tryRob(root.right.right, map);
        }
        int result = Math.max(root.val + res, tryRob(root.left, map) + tryRob(root.right, map));
        map.put(root, result);
        return result;
    }

    public int rob4(TreeNode root) {
            int[] res = tryRob2(root);
            return Math.max(res[0], res[1]);
    }

    private int[] tryRob2(TreeNode root) {
        int[] res ;
        if (root == null) {
            return new int[2];
        }
        int[] left = tryRob2(root.left);
        int[] right = tryRob2(root.right);
        res = new int[2];
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = root.val + left[0] + right[0];
        return res;
    }
}
