// https://leetcode.com/problems/course-schedule-ii/description/
// Status = AC

package com.leetcode.main.solution;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;


public class CourseScheduleII {

  class Graph {

    private int V;
    private List<List<Integer>> adjList;

    public Graph(int v) {
      this.V = v;
      this.adjList = new ArrayList<>();

      for (int i = 0; i < v; i++) {
        this.adjList.add(new ArrayList<>());
      }
    }

    public void addEdge(int u, int v) {
      adjList.get(u).add(v);
    }

    public boolean isCyclic() {
      Set<Integer> seen = new HashSet<>();
      Set<Integer> recStack = new HashSet<>();

      for (int i = 0; i < V; i++) {
        if (!seen.contains(i) && isCyclicUtil(i, seen, recStack)) {
          return true;
        }
      }

      return false;
    }

    private boolean isCyclicUtil(int v, Set<Integer> seen, Set<Integer> recStack) {
      seen.add(v);
      recStack.add(v);

      List<Integer> neighbours = adjList.get(v);

      for (int x : neighbours) {
        if (!seen.contains(x) && isCyclicUtil(x, seen, recStack)) {
          return true;
        } else if (recStack.contains(x)) {
          return true;
        }
      }

      recStack.remove(v);
      return false;
    }

    public List<Integer> topSort() {
      Set<Integer> seen = new HashSet<>();
      Stack<Integer> st = new Stack<>();

      List<Integer> order = new ArrayList<>();

      for (int i = 0; i < V; i++) {
        if (!seen.contains(i)) {
          topSortUtil(i, seen, st);
        }
      }

      while (!st.empty()) {
        order.add(st.pop());
      }

      return order;
    }

    private void topSortUtil(int v, Set<Integer> seen, Stack<Integer> st) {
      seen.add(v);

      List<Integer> neighbours = adjList.get(v);

      for (int x : neighbours) {
        if (!seen.contains(x)) {
          topSortUtil(x, seen, st);
        }
      }

      // this push to stack of v is key to topSort
      st.push(v);
    }
  }

  public int[] findOrder(int numCourses, int[][] prerequisites) {
    if (numCourses == 0) {
      return new int[]{};
    }

    Graph g = new Graph(numCourses);

    for (int i = 0; i < prerequisites.length; i++) {
      g.addEdge(prerequisites[i][1], prerequisites[i][0]);
    }

    if (g.isCyclic()) {
      return new int[]{};
    }

    List<Integer> order = g.topSort();

    int[] orderArray = new int[order.size()];
    for (int i = 0; i < order.size(); i++) {
      orderArray[i] = order.get(i);
    }

    return orderArray;
  }
}
