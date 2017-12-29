// https://leetcode.com/problems/island-perimeter/description/
// Status = AC
package com.leetcode.main.solution;

public class IslandPerimeter {

  public int islandPerimeter(int[][] grid) {
    if (grid == null || grid.length == 0 || grid[0].length == 0) {
      return 0;
    }

    int N = grid.length;
    int M = grid[0].length;

    int pr = 0;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (grid[i][j] == 1) {
          pr += 4;

          if (i > 0 && grid[i - 1][j] == 1) {
            pr -= 2;
          }

          if (j > 0 && grid[i][j - 1] == 1) {
            pr -= 2;
          }
        }
      }
    }

    return pr;
  }
}
