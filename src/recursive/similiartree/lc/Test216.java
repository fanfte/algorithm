package recursive.similiartree.lc;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tianen on 2019/2/12
 *
 * @author fanfte
 * @date 2019/2/12
 **/
public class Test216 {

    private int[] arrs = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tempRes = new ArrayList<>();

        if (k <= 0 || n <= 0 | k > n) {
            return res;
        }

        findCombinations(res, tempRes, n, k, 1, 0);
        return res;
    }

    private void findCombinations(List<List<Integer>> res, List<Integer> tempRes, int n, int k, int index, int count) {

        if (count == k && n == 0) {
            ArrayList<Integer> integers = new ArrayList<>(tempRes);
            res.add(integers);
            return;
        }
        if (count == k) {
            return;
        }

        for (int i = index; i <= arrs.length - 1; i ++) {
            tempRes.add(i);
            findCombinations(res, tempRes, n - i, k, i + 1, count + 1);
            tempRes.remove(tempRes.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Test216().combinationSum3(2, 18));
    }
}
