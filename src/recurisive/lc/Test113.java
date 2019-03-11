package recurisive.lc;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tianen on 2019/2/7
 *
 * @author fanfte
 * @date 2019/2/7
 **/
public class Test113 {
    public void getList(TreeNode node, int sum, List<List<Integer>> res, List<Integer> oneArr) {
        if (node == null) {
            return;
        }
        oneArr.add(node.val);
        if (node.left == null && node.right == null && node.val == sum) {
            res.add(new ArrayList<>(oneArr));
            return;
        }
        if (node.left != null) {
            getList(node.left, sum - node.val, res, oneArr);
            oneArr.remove(oneArr.size() - 1);
        }
        if (node.right != null) {
            getList(node.right, sum - node.val, res, oneArr);
            oneArr.remove(oneArr.size() - 1);
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        getList(root, sum, res, new ArrayList<>());
        return res;
    }
}
