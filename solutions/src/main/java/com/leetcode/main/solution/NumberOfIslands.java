// https://leetcode.com/problems/number-of-islands/description/
// Status = AC

package com.leetcode.main.solution;

public class NumberOfIslands {

  private int r[] = new int[]{-1, 0, 0, 1};
  private int c[] = new int[]{0, -1, 1, 0};

  public int numIslands(char[][] grid) {
    if (grid == null || grid.length == 0) {
      return 0;
    }

    int N = grid.length;
    int M = grid[0].length;

    boolean seen[][] = new boolean[N][M];

    int count = 0;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (grid[i][j] == '1' && !seen[i][j]) {
          dfsUtil(grid, i, j, seen);
          count++;
        }
      }
    }

    return count;
  }


  public void dfsUtil(char[][] grid, int i, int j, boolean[][] seen) {
    seen[i][j] = true;

    for (int k = 0; k < r.length; k++) {
      int x = i + r[k];
      int y = j + c[k];

      if (isSafe(grid, x, y) && !seen[x][y]) {
        dfsUtil(grid, x, y, seen);
      }
    }
  }

  public boolean isSafe(char[][] grid, int x, int y) {
    int N = grid.length;
    int M = grid[0].length;

    return (x >= 0 && x < N && y >= 0 && y < M && grid[x][y] == '1');
  }
}
