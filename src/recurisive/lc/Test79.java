package recurisive.lc;

import java.util.Arrays;

/**
 * Created by tianen on 2019/2/17
 *
 * @author fanfte
 * @date 2019/2/17
 **/
public class Test79 {

    int[][] dir = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};

    boolean[][] visited ;

    public boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (searchWord(board, word, 0, i, j) ) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean searchWord(char[][] board, String word, int index, int startx, int starty) {

        if (index == word.length() - 1) {
            return word.charAt(index) == board[startx][starty];
        }
        if (word.charAt(index) == board[startx][starty]) {
            visited[startx][starty] = true;
            for (int i = 0; i < 4 ;i ++) {
                int newx = startx + dir[i][0];
                int newy = starty + dir[i][1];
                if (inArea(newx, newy, board.length - 1, board[0].length - 1) && !visited[newx][newy]) {
                    if (searchWord(board, word, index + 1, newx, newy)) {
                        return true;
                    }
                }
            }
            visited[startx][starty] = false;
        }
        return false;
    }

    private boolean inArea(int newx, int newy, int width, int height) {
        return newx >= 0 && newx <= width && newy >= 0 && newy <= height;
    }

    public static void main(String[] args) {
        char[][] ch = new char[][] {{'a', 'b'}};
        new Test79().exist(ch, "ba");
    }
}
