package recurisive.lc;

/**
 * Created by tianen on 2019/2/17
 *
 * @author fanfte
 * @date 2019/2/17
 **/
public class Test200 {
    int[][] dir = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};
    boolean[][] visited;
    int m, n;
    public int numIslands(char[][] grid) {
        int res = 0;

        m = grid.length;
        if (m == 0) {
            return 0;
        }
        n = grid[0].length;

        visited = new boolean[m][n];
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    res ++;
                    floodFill(grid, i, j);
                }
            }
        }
        return res;
    }

    private void floodFill(char[][] grid, int x, int y) {

        visited[x][y] = true;
        for (int i = 0; i < 4; i ++) {
            int newx = x + dir[i][0];
            int newy = y + dir[i][1];
            if (inArea(newx, newy) && !visited[newx][newy] && grid[newx][newy] == '1') {
                floodFill(grid, newx, newy);
            }
        }
    }

    private boolean inArea(int newx, int newy) {
        return newx >= 0 && newx < m && newy >= 0 && newy < n;
    }

    public static void main(String[] args) {
        char[][] grid = {{'1', '1','1', '1', '0'}, {'1','1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
        System.out.println(new Test200().numIslands(grid));
    }
}
