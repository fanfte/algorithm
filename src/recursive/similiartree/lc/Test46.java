package recursive.similiartree.lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by tianen on 2019/2/11
 *
 * @author fanfte
 * @date 2019/2/11
 **/
public class Test46 {

    private boolean[] used ;

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tempRes = new ArrayList<>();
        used = new boolean[nums.length];
        Arrays.fill(used, false);
        findNums(res, tempRes, nums, 0);
        return res;
    }

    private void findNums(List<List<Integer>> res, List<Integer> tempRes, int[] nums, int index) {

        if (index == nums.length) {
            res.add(new ArrayList<>(tempRes));
            return;
        }

        for (int i = 0; i < nums.length; i ++) {
            if (!used[i]) {
                used[i] = true;
                tempRes.add(nums[i]);
                findNums(res, tempRes, nums, index + 1);
                tempRes.remove(tempRes.size() - 1);
                used[i] = false;
            }
        }
    }


}
