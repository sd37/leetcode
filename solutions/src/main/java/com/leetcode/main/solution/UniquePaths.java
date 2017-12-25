// https://leetcode.com/problems/unique-paths/description/
// Status = AC
package com.leetcode.main.solution;

// note the ans for 1 * 1 grid is 0. So when i == n - 1 and j == m -1,
// paths[n - 1][m - 1] should be 1 instead of zero.

public class UniquePaths {

  public int uniquePaths(int m, int n) {
    int[][] paths = new int[m][n];

    for (int i = m - 1; i >= 0; i--) {
      for (int j = n - 1; j >= 0; j--) {
        if (i == m - 1 || j == n - 1) {
          paths[i][j] = 1;
        } else {
          paths[i][j] = paths[i + 1][j] + paths[i][j + 1];
        }
      }
    }

    return paths[0][0];
  }
}
