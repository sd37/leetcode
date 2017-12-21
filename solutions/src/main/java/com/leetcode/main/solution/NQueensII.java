// https://leetcode.com/problems/n-queens-ii/description/
// Status = AC
package com.leetcode.main.solution;

public class NQueensII {
  private int count = 0;
  public int totalNQueens(int n) {
    if(n <= 0) {
      return 0;
    }

    int[][] board = new int[n][n];

    totalNQueensUtil(board, 0);

    return count;
  }

  private boolean totalNQueensUtil(int[][] board, int col) {
    if(col >= board.length) {
      count++;
      return true;
    }

    for (int i = 0; i < board.length; i++) {
      if(isSafe(board, i, col)) {
        board[i][col] = 1;
        totalNQueensUtil(board, col + 1);
        board[i][col] = 0;
      }
    }

    return false;
  }

  private boolean isSafe(int board[][], int row, int col) {
    int i, j;
    int N = board.length;

    /* Check this row on left side */
    for (i = 0; i < col; i++) {
      if (board[row][i] == 1) {
        return false;
      }
    }

    /* Check upper diagonal on left side */
    for (i = row, j = col; i >= 0 && j >= 0; i--, j--) {
      if (board[i][j] == 1) {
        return false;
      }
    }

    /* Check lower diagonal on left side */
    for (i = row, j = col; j >= 0 && i < N; i++, j--) {
      if (board[i][j] == 1) {
        return false;
      }
    }

    return true;
  }
}
