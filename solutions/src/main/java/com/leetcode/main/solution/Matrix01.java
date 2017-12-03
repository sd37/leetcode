// https://leetcode.com/problems/01-matrix/description/
// status = AC
package com.leetcode.main.solution;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class Matrix01 {

  private int r[] = new int[]{-1, 0, 0, 1};
  private int c[] = new int[]{0, -1, 1, 0};

  public int[][] updateMatrix(int[][] matrix) {
    int N = matrix.length;
    int M = matrix[0].length;

    if (N == 0) {
      return matrix;
    }

    int[][] dist = new int[N][M];

    for (int i = 0; i < N; i++) {
      Arrays.fill(dist[i], Integer.MAX_VALUE - 1);
    }

    //First pass: check for left and top
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (matrix[i][j] == 0) {
          dist[i][j] = 0;
        } else {
          if (i > 0) {
            dist[i][j] = Math.min(dist[i][j], dist[i - 1][j] + 1);
          }
          if (j > 0) {
            dist[i][j] = Math.min(dist[i][j], dist[i][j - 1] + 1);
          }
        }
      }
    }

    //Second pass: check for bottom and right
    for (int i = N - 1; i >= 0; i--) {
      for (int j = M - 1; j >= 0; j--) {
        if (i < N - 1) {
          dist[i][j] = Math.min(dist[i][j], dist[i + 1][j] + 1);
        }
        if (j < M - 1) {
          dist[i][j] = Math.min(dist[i][j], dist[i][j + 1] + 1);
        }
      }
    }

    return dist;
  }

  // do smarter bfs.
  // start from 0 and calculate the distance to all 1s.
  public int[][] updateMatrixBfsLittleFaster(int[][] matrix) {
    int N = matrix.length;
    int M = matrix[0].length;

    if (N == 0) {
      return matrix;
    }

    int[][] dist = new int[N][M];

    for (int i = 0; i < N; i++) {
      Arrays.fill(dist[i], Integer.MAX_VALUE);
    }

    Deque<List<Integer>> q = new ArrayDeque<>();

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (matrix[i][j] == 0) {
          dist[i][j] = 0;
          q.add(Arrays.asList(i, j));
        }
      }
    }

    while (!q.isEmpty()) {
      List<Integer> curr = q.poll();

      for (int i = 0; i < r.length; i++) {
        int nextI = curr.get(0) + r[i];
        int nextJ = curr.get(1) + c[i];

        if (isSafe(matrix, nextI, nextJ)) {
          if (dist[nextI][nextJ] > dist[curr.get(0)][curr.get(1)] + 1) {
            dist[nextI][nextJ] = dist[curr.get(0)][curr.get(1)] + 1;
            q.push(Arrays.asList(nextI, nextJ));
          }
        }
      }
    }

    return dist;
  }

  public int[][] updateMatrixSlowBfs(int[][] matrix) {
    int N = matrix.length;
    int M = matrix[0].length;

    int[][] soln = new int[N][M];

    for (int i = 0; i < N; i++) {
      Arrays.fill(soln[i], -1);
    }

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (matrix[i][j] == 0) {
          soln[i][j] = 0;
        }
      }
    }

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (matrix[i][j] == 1) {
          soln[i][j] = bfsUtil(matrix, i, j, N, M, soln);
        }

      }
    }

    return soln;
  }

  private int bfsUtil(int[][] matrix, int i, int j, int N, int M, int[][] soln) {
    boolean seen[][] = new boolean[N][M];
    Deque<List<Integer>> q = new ArrayDeque<>();

    q.add(Arrays.asList(i, j, 0));

    seen[i][j] = true;

    while (!q.isEmpty()) {
      List<Integer> e = q.poll();

      for (int k = 0; k < r.length; k++) {
        int nextI = e.get(0) + r[k];
        int nextJ = e.get(1) + c[k];
        int dist = e.get(2);

        if (isSafe(matrix, nextI, nextJ) && !seen[nextI][nextJ]) {
          seen[nextI][nextJ] = true;
          if (matrix[nextI][nextJ] == 0) {
            return dist + 1;
          }

          q.add(Arrays.asList(nextI, nextJ, dist + 1));
        }
      }
    }

    // shouldn't reach here.
    return -1;
  }

  private boolean isSafe(int[][] matrix, int x, int y) {
    int N = matrix.length;
    int M = matrix[0].length;

    return (x >= 0 && x < N && y >= 0 && y < M);
  }
}
