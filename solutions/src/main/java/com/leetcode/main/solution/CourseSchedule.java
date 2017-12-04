// https://leetcode.com/problems/course-schedule/description/
// Status = AC

package com.leetcode.main.solution;

import java.util.ArrayList;
import java.util.List;

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
    boolean[] seen = new boolean[V];
    boolean[] recStack = new boolean[V];

    for (int i = 0; i < V; i++) {
      if(!seen[i] && isCyclicUtil(i, seen, recStack)) {
        return true;
      }
    }

    return false;
  }

  private boolean isCyclicUtil(int v, boolean[] seen, boolean[] recStack) {
    seen[v] = true;
    recStack[v] = true;

    List<Integer> neighbours = adjList.get(v);

    for(int x : neighbours) {
      if(!seen[x] && isCyclicUtil(x, seen, recStack)) {
        return true;
      } else if(recStack[x]) {
        return true;
      }
    }

    recStack[v] = false;
    return false;
  }
}

public class CourseSchedule {
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    if(numCourses == 0) {
      return true;
    }

    if(prerequisites.length == 0) {
      return true;
    }

    Graph g = new Graph(numCourses);

    for(int i = 0; i < prerequisites.length; i++) {
      g.addEdge(prerequisites[i][1], prerequisites[i][0]);
    }

    return !g.isCyclic();
  }
}
