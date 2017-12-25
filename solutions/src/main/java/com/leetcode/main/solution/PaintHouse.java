// https://leetcode.com/problems/paint-house/discuss/
// status = AC

package com.leetcode.main.solution;

import java.util.Arrays;
import java.util.Collections;

public class PaintHouse {

  public int minCost(int[][] costs) {
    if (costs == null || costs.length == 0) {
      return 0;
    }

    int N = costs.length;
    int M = 3;

    int[][] costComp = new int[N][M];

    for (int c = 0; c < M; c++) {
      costComp[0][c] = costs[0][c];
    }

    for (int h = 1; h < N; h++) {
      costComp[h][0] = costs[h][0] + Math.min(costComp[h - 1][1], costComp[h - 1][2]);
      costComp[h][1] = costs[h][1] + Math.min(costComp[h - 1][0], costComp[h - 1][2]);
      costComp[h][2] = costs[h][2] + Math.min(costComp[h - 1][0], costComp[h - 1][1]);
    }

    return Collections.min(Arrays.asList(costComp[N - 1][0], costComp[N - 1][1], costComp[N - 1][2]));
  }
}
