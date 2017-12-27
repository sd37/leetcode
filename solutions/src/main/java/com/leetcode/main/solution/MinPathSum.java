// https://leetcode.com/problems/minimum-path-sum/description/
// Status = AC

package com.leetcode.main.solution;

public class MinPathSum {

  public int minPathSum(int[][] grid) {
    int N = grid.length;
    int M = grid[0].length;

    int[][] paths = new int[N][M];

    paths[N - 1][M - 1] = grid[N - 1][M - 1];

    for (int i = N - 2; i >= 0; i--) {
      paths[i][M - 1] = paths[i + 1][M - 1] + grid[i][M - 1];
    }

    for (int j = M - 2; j >= 0; j--) {
      paths[N - 1][j] = paths[N - 1][j + 1] + grid[N - 1][j];
    }

    for (int i = N - 2; i >= 0; i--) {
      for (int j = M - 2; j >= 0; j--) {
        paths[i][j] = grid[i][j] + Math.min(paths[i + 1][j], paths[i][j + 1]);
      }
    }

    return paths[0][0];
  }
}
