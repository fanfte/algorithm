package recurisive.lc;

/**
 * Created by tianen on 2019/2/9
 *
 * @author fanfte
 * @date 2019/2/9
 **/
public class Test108 {

    public TreeNode sortedArrayToBST(int[] nums) {
        return construct(nums, 0, nums.length - 1);
    }

    public TreeNode construct(int[] nums, int left, int right) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        if (left > right) {
            return null;
        }
        int middle = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[middle]);
        root.left = construct(nums, left, middle - 1);
        root.right = construct(nums, middle + 1, right);
        return root;
    }
}
