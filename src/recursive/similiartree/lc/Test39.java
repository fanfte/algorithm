package recursive.similiartree.lc;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tianen on 2019/2/12
 *
 * @author fanfte
 * @date 2019/2/12
 **/
public class Test39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tempRes = new ArrayList<>();
        if (candidates == null || candidates.length == 0 ) {
            return res;
        }
        findCombinations(res, tempRes, candidates, target, 0);
        return res;
    }

    private void findCombinations(List<List<Integer>> res, List<Integer> tempRes, int[] candidates, int target, int index) {

        if (target == 0) {
            res.add(new ArrayList<>(tempRes));
            return;
        }
        if (target < 0) {
            return;
        }

        for (int i = index; i < candidates.length ; i ++) {
            tempRes.add(candidates[i]);
            findCombinations(res, tempRes, candidates, target - candidates[i], index);
            index ++;
            tempRes.remove(tempRes.size() - 1);
        }
    }
}
