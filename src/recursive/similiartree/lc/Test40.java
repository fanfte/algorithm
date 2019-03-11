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
public class Test40 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tempRes = new ArrayList<>();

        if (candidates.length == 0 ) {
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
            if (i > index && candidates[i] == candidates[i - 1])  {
                continue;
            }
            tempRes.add(candidates[i]);
            findCombinations(res, tempRes, candidates, target - candidates[i], i + 1);
            tempRes.remove(tempRes.size() - 1);
        }
    }

}
