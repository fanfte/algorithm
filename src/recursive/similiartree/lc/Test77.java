package recursive.similiartree.lc;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tianen on 2019/2/11
 *
 * @author fanfte
 * @date 2019/2/11
 **/
public class Test77 {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tempRes = new ArrayList<>();

        if (n <= 0 || k <= 0 || k > n) {
            return res;
        }
        findCombinations(res, tempRes, n, k, 1);
        return res;
    }

    private void findCombinations(List<List<Integer>> res, List<Integer> tempRes, int n, int k, int index) {

        if (tempRes.size() == k) {
            ArrayList<Integer> oneCombine = new ArrayList<>(tempRes);
            res.add(oneCombine);
            return;
        }

        for (int i = index; i <= n; i ++) {
            tempRes.add(i);
            findCombinations(res, tempRes, n, k, i + 1);
            tempRes.remove(tempRes.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Test77().combine(4, 2));
    }

}
