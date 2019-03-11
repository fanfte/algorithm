package recurisive.lc;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tianen on 2019/2/7
 *
 * @author fanfte
 * @date 2019/2/7
 **/
public class Test257 {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();

        if (root == null) {
            return res;
        }
        if (root.left == null && root.right == null) {
            res.add(root.val + "");
            return res;
        }
        List<String> leftStrings = binaryTreePaths(root.left);
        List<String> rightStrings = binaryTreePaths(root.right);
        for (String s : leftStrings) {
           res.add(root.val + "->" + s);
        }
        for (String s : rightStrings) {
            res.add(root.val + "->" + s);
        }
        return res;
    }
}
