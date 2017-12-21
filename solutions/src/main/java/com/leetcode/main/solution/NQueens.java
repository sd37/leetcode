// https://leetcode.com/problems/n-queens/description/
// Status = AC
package com.leetcode.main.solution;

import java.util.ArrayList;
import java.util.List;

public class NQueens {

  public List<List<String>> solveNQueens(int n) {
    List<List<String>> ans = new ArrayList<>();

    if (n <= 0) {
      return ans;
    }

    int[][] board = new int[n][n];

    solveNQueensUtil(board, 0, ans);

    return ans;
  }

  private boolean solveNQueensUtil(int[][] board, int col, List<List<String>> ans) {
    if (col >= board[0].length) {
      ans.add(convertBoardToString(board));
      return true;
    }

    for (int i = 0; i < board.length; i++) {
      if (isSafe(board, i, col)) {
        board[i][col] = 1;
        solveNQueensUtil(board, col + 1, ans);
        board[i][col] = 0;
      }
    }

    return false;
  }

  private List<String> convertBoardToString(int[][] board) {
    List<String> res = new ArrayList<>();

    for (int i = 0; i < board.length; i++) {
      StringBuilder interSoln = new StringBuilder();
      for (int j = 0; j < board[0].length; j++) {
        char ch = board[i][j] == 1 ? 'Q' : '.';
        interSoln.append(ch);
      }

      res.add(new String(interSoln));
    }

    return res;
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
