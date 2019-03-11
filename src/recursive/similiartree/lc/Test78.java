package recursive.similiartree.lc;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tianen on 2019/2/12
 *
 * @author fanfte
 * @date 2019/2/12
 **/
public class Test78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tempRes = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            return res;
        }
        res.add(new ArrayList<>());
        findSubSets(res, tempRes, nums, 0);
        return res;
    }

    private void findSubSets(List<List<Integer>> res, List<Integer> tempRes, int[] nums, int index) {

        for (int i = index ;i < nums.length; i ++) {
            tempRes.add(nums[i]);
            res.add(new ArrayList<>(tempRes));
            findSubSets(res, tempRes, nums, i + 1);
            tempRes.remove(tempRes.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Test78().subsets(new int[]{1, 2, 3}));
    }
}
