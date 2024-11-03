// https://leetcode.com/problems/course-schedule/description/
// Status = AC

package com.leetcode.main.solution;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CourseSchedule {
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
            Set<Integer> seen = new HashSet<>(); // needed to track of disconnected components.
            Set<Integer> recStack = new HashSet<>();

            for (int i = 0; i < this.V; i++) {
                if (seen.contains(i)) {
                    continue;
                }

                if (isCyclicUtil(i, seen, recStack)) {
                    return true;
                }
            }

            return false;
        }

        private boolean isCyclicUtil(int v, Set<Integer> seen, Set<Integer> recStack) {
            seen.add(v);
            recStack.add(v);

            var neighbors = this.adjList.get(v);

            for (var x : neighbors) {
                if (seen.contains(x) && recStack.contains(x)) {
                    return true;
                }

                if (seen.contains(x)) {
                    continue;
                }

                if (isCyclicUtil(x, seen, recStack)) {
                    return true;
                }
            }

            recStack.remove(v);
            return false;
        }
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) {
            return true;
        }

        if (prerequisites.length == 0) {
            return true;
        }

        Graph g = new Graph(numCourses);

        for (int i = 0; i < prerequisites.length; i++) {
            g.addEdge(prerequisites[i][1], prerequisites[i][0]);
        }

        return !g.isCyclic();
    }
}
