// https://leetcode.com/problems/friend-circles/discuss/
// Status = AC

package com.leetcode.main.solution;

@SuppressWarnings("ALL")
class DisjointSet {

  private int N;
  private int[] parents;

  public DisjointSet(int N) {
    this.N = N;
    this.parents = new int[N];

    for (int i = 0; i < N; i++) {
      this.parents[i] = i;
    }
  }

  // boolean value tells us if union actually happened or not.
  public void union(int i, int j) {
    int repI = find(i);
    int repJ = find(j);

    if (repI == repJ) {
      return;
    }

    // merge
    parents[repI] = repJ;

    N--;
  }

  // here we do path compression in find.
  public int find(int i) {
    if (parents[i] != i) {
      parents[i] = find(parents[i]);
    }
    return parents[i];
  }

  public int getNumSets() {
    return N;
  }
}

public class FriendCircles {

  public int findCircleNum(int[][] M) {
    if (M == null) {
      return 0;
    }

    int N = M[0].length;

    DisjointSet ds = new DisjointSet(N);

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (M[i][j] == 1) {
          ds.union(i,j);
        }
      }
    }

    return ds.getNumSets();
  }
}
