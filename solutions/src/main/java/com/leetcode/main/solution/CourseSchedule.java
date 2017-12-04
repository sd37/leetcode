// https://leetcode.com/problems/course-schedule/description/
// Status = AC

package com.leetcode.main.solution;

    import java.util.ArrayList;
    import java.util.HashSet;
    import java.util.List;
    import java.util.Set;

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
      if(!seen.contains(i) && isCyclicUtil(i, seen, recStack)) {
        return true;
      }
    }

    return false;
  }

  private boolean isCyclicUtil(int v, Set<Integer> seen, Set<Integer> recStack) {
    seen.add(v);
    recStack.add(v);

    List<Integer> neighbours = adjList.get(v);

    for(int x : neighbours) {
      if(!seen.contains(x) && isCyclicUtil(x, seen, recStack)) {
        return true;
      } else if(recStack.contains(x)) {
        return true;
      }
    }

    recStack.remove(v);
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
