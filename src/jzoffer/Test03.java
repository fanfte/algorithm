package jzoffer;

/**
 * Created by tianen on 2019/3/20
 *
 * @author fanfte
 * @date 2019/3/20
 **/
public class Test03 {

    /**
     * 从右上角开始比较
     */
    public boolean findInPartiallySortedMatrix(int[][] matrix, int num) {
        int row = 0;
        if (matrix == null || matrix[0].length == 0) {
            return false;
        }
        int col = matrix[0].length - 1;
        int rows = matrix.length;
        int cols = matrix[0].length;
        while (row < rows && col >= 0) {
           if (matrix[row][col] == num) {
               return true;
           } else if (matrix[row][col] < num) {
               row ++;
           } else {
               col --;
           }
        }
        return false;
    }

    /**
     * 从左下角开始比较
     */
    public boolean findInPartiallySortedMatrix2(int[][] matrix, int num) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        int row = rows - 1;
        int col = 0;

        while( col < cols && row >= 0) {
            if (matrix[row][col] == num) {
                return true;
            } else if (matrix[row][col] < num) {
                col ++;
            } else {
                row --;
            }
        }
        return false;
    }
}
