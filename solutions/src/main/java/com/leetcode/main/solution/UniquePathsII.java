// https://leetcode.com/problems/unique-paths-ii/description/
// status = AC

package com.leetcode.main.solution;

public class UniquePathsII {

  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    int N = obstacleGrid.length;
    int M = obstacleGrid[0].length;

    int[][] paths = new int[N][M];

    int obstacleCount = 0;
    for (int i = N - 1; i >= 0; i--) {
      if (obstacleGrid[i][M - 1] == 1) {
        obstacleCount++;
      }
      paths[i][M - 1] = obstacleCount > 0 ? 0 : 1;
    }

    obstacleCount = 0;
    for (int j = M - 1; j >= 0; j--) {
      if (obstacleGrid[N - 1][j] == 1) {
        obstacleCount++;
      }
      paths[N - 1][j] = obstacleCount > 0 ? 0 : 1;
    }

    for (int i = N - 2; i >= 0; i--) {
      for (int j = M - 2; j >= 0; j--) {
        if (obstacleGrid[i][j] == 1) {
          paths[i][j] = 0;
        } else {
          paths[i][j] = paths[i + 1][j] + paths[i][j + 1];
        }
      }
    }

    return paths[0][0];
  }
}
