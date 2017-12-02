// https://leetcode.com/problems/flood-fill/description/
// Status = AC

package com.leetcode.main.solution;

public class FloodFill {

  private int r[] = new int[]{-1, 0, 0, 1};
  private int c[] = new int[]{0, -1, 1, 0};

  public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
    if (image == null || image.length == 0) {
      return image;
    }

    int N = image.length;
    int M = image[0].length;

    int originalColor = image[sr][sc];

    // this base case is important otherwise code will not terminate.
    if(originalColor == newColor) {
      return image;
    }

    dfsUtil(image, sr, sc, newColor, originalColor);

    return image;
  }

  public void dfsUtil(int[][] image, int x, int y, int newColor, int originalColor) {
    image[x][y] = newColor;

    for (int i = 0; i < r.length; i++) {
      int nextX = x + r[i];
      int nextY = y + c[i];

      if(isSafe(image, nextX, nextY, originalColor)) {
        dfsUtil(image, nextX, nextY, newColor, originalColor);
      }
    }
  }

  public boolean isSafe(int[][] image, int x, int y, int originalColor) {
    int N = image.length;
    int M = image[0].length;

    return (x >= 0 && x < N && y >= 0 && y < M && originalColor == image[x][y]);
  }
}
