// https://leetcode.com/problems/unique-binary-search-trees/discuss/
// Status = AC
package com.leetcode.main.solution;

public class UniqueBST {

  public int numTrees(int n) {
    if (n <= 1) {
      return 1;
    }

    int[] g = new int[n + 1];

    g[0] = 1;
    g[1] = 1;

    for (int i = 2; i <= n; i++) {
      for (int j = 1; j <= i; j++) {
        g[i] += g[j - 1] * g[i - j];
      }
    }

    return g[n];
  }
}
