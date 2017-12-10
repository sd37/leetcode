// https://leetcode.com/problems/graph-valid-tree/description/
// Status = AC

package com.leetcode.main.solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ValidTree {

  class Graph {

    private int V;
    Map<Integer, List<Integer>> adjList;

    public Graph(int n) {
      this.V = n;
      this.adjList = new HashMap<>();
      for (int i = 0; i < n; i++) {
        adjList.put(i, new ArrayList<>());
      }
    }

    public void addEdge(int u, int v) {
      adjList.get(u).add(v);
      adjList.get(v).add(u);
    }

    public boolean isConnected() {
      int root = 0;
      Set<Integer> seen = new HashSet<>();

      dfsUtil(root, seen);

      return seen.size() == V;
    }

    private void dfsUtil(int root, Set<Integer> seen) {
      seen.add(root);

      for (int x : adjList.get(root)) {
        if (!seen.contains(x)) {
          dfsUtil(x, seen);
        }
      }
    }
  }

  public boolean validTree(int n, int[][] edges) {

    if (edges.length != n - 1) {
      return false;
    }

    Graph g = new Graph(n);

    for (int i = 0; i < edges.length; i++) {
      int u = edges[i][0];
      int v = edges[i][1];
      g.addEdge(u, v);
    }

    return g.isConnected();
  }
}
