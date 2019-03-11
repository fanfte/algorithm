package recursive.similiartree.lc;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tianen on 2019/2/25
 *
 * @author fanfte
 * @date 2019/2/25
 **/
public class Test51 {

    List<List<String>> res = new ArrayList<>();
    boolean[] col;
    boolean[] dia1;
    boolean[] dia2;
    public List<List<String>> solveNQueens(int n) {

        if (n <= 0) {
            return res;
        }
        col = new boolean[n];
        dia1 = new boolean[2 * n - 1];
        dia2 = new boolean[2 * n - 1];

        char[][] board = new char[n][n];
        for (int i = 0; i < n ;i ++) {
            for (int j = 0; j < n ; j ++) {
                board[i][j] = '.';
            }
        }
        putQueen(n, 0, board);
        return res;
    }

    private void putQueen(int n, int index, char[][] board) {
        if (index == n) {
            res.add(createSolve(board));
            return;
        }

        for (int i = 0; i < n; i ++) {
            if (!col[i] && !dia1[index + i] && !dia2[n - 1 + index - i]) {
                board[index][i] = 'Q';
                col[i] = true;
                dia1[index + i] = true;
                dia2[n - 1 + index - i] = true;

                putQueen(n, index + 1, board);
                col[i] = false;
                dia1[index + i] = false;
                dia2[n - 1 + index - i ] = false;
                board[index][i] = '.';
            }
        }
    }

    private List<String> createSolve(char[][] board) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < board.length; i ++) {
            result.add(new String(board[i]));
        }
        return null;
    }

    public static void main(String[] args) {
        new Test51().solveNQueens(4);
    }
}
