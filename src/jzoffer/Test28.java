package jzoffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by tianen on 2019/4/2
 *
 * @author fanfte
 * @date 2019/4/2
 **/
public class Test28 {

    public static void permutation(char[] chars) {
        if (chars == null || chars.length == 0) {
            return;
        }
        boolean[] used = new boolean[chars.length];
        Arrays.fill(used, false);
        List<List<Character>> res = new ArrayList<>();
        List<Character> temp = new ArrayList<>();
        permutate(chars, temp, res, 0, used);

        for (List<Character> item : res) {
            System.out.println(item);
        }
    }

    private static void permutate(char[] chars, List<Character> temp, List<List<Character>> res, int index, boolean[] used) {
        if (index == chars.length) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            if (!used[i]) {
                temp.add(chars[i]);
                used[i] = true;
                permutate(chars, temp, res, index + 1, used);
                used[i] = false;
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        char[] c1 = {'a', 'b', 'c'};
        permutation(c1);
        System.out.println();
        char[] c2 = {'a', 'b', 'c', 'd'};
        permutation(c2);
    }

}
