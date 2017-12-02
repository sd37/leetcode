// https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/description/
// Status = AC

package com.leetcode.main.solution;

public class CountComponents {
  class DisjointSet {

    private int n;
    private int[] parent;

    public DisjointSet(int n) {
      this.n = n;
      this.parent = new int[n];

      for (int i = 0; i < n; i++) {
        this.parent[i] = i;
      }
    }

    public int find(int i) {
      if (parent[i] != i) {
        parent[i] = find(parent[i]);
      }
      return parent[i];
    }

    public void union(int i, int j) {
      int reprI = find(i);
      int reprJ = find(j);

      if (reprI == reprJ) {
        return;
      }

      parent[reprI] = reprJ;
      n--;
    }

    public int getN() {
      return n;
    }
  }

  public int countComponents(int n, int[][] edges) {

    if(edges == null || n == 0) {
      return 0;
    }

    DisjointSet ds = new DisjointSet(n);

    for (int i = 0; i < edges.length; i++) {
      int x = edges[i][0];
      int y = edges[i][1];

      ds.union(x, y);
    }

    return ds.getN();
  }
}
