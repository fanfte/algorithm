package recurisive.lc;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tianen on 2019/2/7
 *
 * @author fanfte
 * @date 2019/2/7
 **/
public class Test129 {

    public int sumNumbers(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        getNum(root, new ArrayList<>(), res);
        int result = 0;
        for (List<Integer> num : res) {
            StringBuffer sb = new StringBuffer();
            for (Integer integer : num) {
                sb.append(integer);
            }
            result += Integer.valueOf(sb.toString());
        }
        return result;
    }

    public void getNum(TreeNode node, List<Integer> oneNum, List<List<Integer>> res) {
        if (node == null) {
            return;
        }
        oneNum.add(node.val);
        if (node.left == null && node.right == null) {
            res.add(new ArrayList<>(oneNum));
            return;
        }
        if (node.left != null) {
            getNum(node.left, oneNum, res);
            oneNum.remove(oneNum.size() - 1);
        }
        if (node.right != null) {
            getNum(node.right, oneNum, res);
            oneNum.remove(oneNum.size() - 1);
        }
    }
}
