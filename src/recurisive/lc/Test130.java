package recurisive.lc;

/**
 * Created by tianen on 2019/2/17
 *
 * @author fanfte
 * @date 2019/2/17
 **/
public class Test130 {

    int[][] dir = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};

    int m, n;
    /**
     * 从外侧开始寻找连续的'O',转化为'*',再将内部的'O'转化为'X'，最后将外部的'*'转化为'O'，即可得到结果
     */
    public void solve(char[][] board) {

        m = board.length;
        if (m <= 0) {
            return;
        }
        n = board[0].length;

        for (int i = 0; i < m; i ++) {
            dfs(board, i, 0);
            dfs(board, i, n - 1);
        }

        for (int i = 0; i < n; i ++) {
            dfs(board, 0, i);
            dfs(board, m - 1, i);
        }

        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '*') {
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }

    }

    private void dfs(char[][] board, int i, int j) {
        int m = board.length;
        int n = board[0].length;

        if (!inArea(i, j) || board[i][j] != 'O') {
            return;
        }

        board[i][j] = '*';
        for (int d = 0; d < 4; d ++) {
            int newx = i + dir[d][0];
            int newy = j + dir[d][1];
            if (inArea(newx, newy) && board[newx][newy] == 'O') {
                dfs(board, newx, newy);
            }
        }
    }

    public boolean inArea(int i, int j) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }

    public static void main(String[] args) {
        char[][] board = {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        char[][] board2 = {{'O','O', 'O'}, {'O', 'O', 'O'}, {'O', 'O', 'O'}};
        new Test130().solve(board2);
    }

}
