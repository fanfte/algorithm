package recursive.similiartree.lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by tianen on 2019/2/12
 *
 * @author fanfte
 * @date 2019/2/12
 **/
public class Test90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        List<Integer> tempRes = new ArrayList<>();

        Arrays.sort(nums);
        if (nums == null || nums.length == 0) {
            return res;
        }
        res.add(new ArrayList<>());
        findSubsets(res, tempRes, nums, 0);

        return res;
    }

    private void findSubsets(List<List<Integer>> res, List<Integer> tempRes, int[] nums, int index) {

        for (int i = index;i < nums.length; i ++) {
            tempRes.add(nums[i]);
            if (!res.contains(tempRes)) {
                res.add(new ArrayList<>(tempRes));
            }
            findSubsets(res, tempRes, nums, i + 1);
            tempRes.remove(tempRes.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Test90().subsetsWithDup(new int[]{1, 2, 2}));
    }
}
