package test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tianen on 2019/5/26
 *
 * @author fanfte
 * @date 2019/5/26
 **/
public class PrintArray {

    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length <= 0 || matrix[0].length <= 0) {
            return new ArrayList<>();
        }
        int startx = 0;
        int starty = 0;
        while (matrix.length > starty * 2 && matrix[0].length > startx * 2) {
            printMatrixInCircle(matrix, startx, starty, result);
            startx ++;
            starty ++;
        }
        return result;
    }

    private void printMatrixInCircle(int[][] matrix, int startx, int starty, ArrayList<Integer> result) {
        int endx = matrix[0].length - startx - 1;
        int endy = matrix.length - starty - 1;
        for (int i = startx; i <= endx; i ++ ) {
            result.add(matrix[starty][i]);
        }
        if (starty < endy) {
            for (int i = starty + 1; i <= endy; i ++) {
                result.add(matrix[i][endx]);
            }
        }
        if (starty < endy && startx < endx) {
            for (int i = endx - 1; i >= startx; i --) {
                result.add(matrix[endy][i]);
            }
        }

        if (startx < endx && starty < endy - 1) {
            for (int i = endy - 1;i >= starty + 1; i --) {
                result.add(matrix[i][startx]);
            }
        }
    }

    public static void main(String[] args) {
        int[][] numbers = {
                {1, 2, 3, 4, 5},
                {16, 17, 18, 19, 6},
                {15, 24, 25, 20, 7},
                {14, 23, 22, 21, 8},
                {13, 12, 11, 10, 9},
        };

        ArrayList<Integer> integers = new PrintArray().printMatrix(numbers);
        for (Integer integer : integers) {
            System.out.print(integer + " ");
        }
    }
}
