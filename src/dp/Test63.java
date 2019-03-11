package dp;

/**
 * Created by tianen on 2019/3/7
 *
 * @author fanfte
 * @date 2019/3/7
 **/
public class Test63 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];

        dp[0][0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int i = 0; i < obstacleGrid.length; i ++) {
            for (int j = 0; j < obstacleGrid[0].length; j ++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else if (j == 0) {
                    if (i > 0) {
                        dp[i][0] = dp[i - 1][0];
                    }
                } else if (i == 0) {
                    if (j > 0) {
                        dp[0][j] = dp[0][j - 1];
                    }
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }
}
