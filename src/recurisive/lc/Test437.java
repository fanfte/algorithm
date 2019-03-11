package recurisive.lc;

/**
 * Created by tianen on 2019/2/8
 *
 * @author fanfte
 * @date 2019/2/8
 **/
public class Test437 {

    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int res = pathSumContainNode(root, sum);
        res += pathSum(root.left, sum);
        res += pathSum(root.right, sum);
        return res;
    }

    public int pathSumContainNode(TreeNode root, int sum) {
        int res = 0;
        if (root == null) {
            return 0;
        }
        if (root.val == sum) {
            res += 1;
        }
        res += pathSumContainNode(root.left, sum - root.val);
        res += pathSumContainNode(root.right, sum - root.val);
        return res;
    }
}
