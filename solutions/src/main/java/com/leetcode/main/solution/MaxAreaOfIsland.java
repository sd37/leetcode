// https://leetcode.com/problems/max-area-of-island/description/
// Status = AC

package com.leetcode.main.solution;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MaxAreaOfIsland {

  private int r[] = new int[]{-1, 0, 0, 1};
  private int c[] = new int[]{0, -1, 1, 0};

  public int maxAreaOfIsland(int[][] grid) {

    if (grid == null || grid.length == 0) {
      return 0;
    }

    int N = grid.length;
    int M = grid[0].length;

    boolean seen[][] = new boolean[N][M];
    Map<Integer, Integer> islands = new HashMap<>();

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (grid[i][j] == 1 && !seen[i][j]) {
          dfsUtil(grid, i, j, islands, seen, M * i + j);
        }
      }
    }

    if(islands.entrySet().size() == 0) {
      return 0;
    }

    return Collections.max(islands.entrySet(), Map.Entry.comparingByValue()).getValue();
  }

  private void dfsUtil(int[][] grid, int i, int j, Map<Integer, Integer> islands,
      boolean seen[][], int label) {

    seen[i][j] = true;
    islands.put(label, islands.getOrDefault(label, 0) + 1);

    for (int k = 0; k < r.length; k++) {
      int x = i + r[k];
      int y = j + c[k];

      if (isSafe(grid, x, y) && !seen[x][y]) {
        dfsUtil(grid, x, y, islands, seen, label);
      }
    }
  }

  private boolean isSafe(int[][] grid, int x, int y) {
    int N = grid.length;
    int M = grid[0].length;
    return (x >= 0 && x < N && y >= 0 && y < M && grid[x][y] == 1);
  }
}
