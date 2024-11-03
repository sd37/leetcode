// https://leetcode.com/problems/course-schedule-ii/description/
// Status = AC

package com.leetcode.main.solution;

import java.util.*;

public class CourseScheduleII {
    class Graph {
        private int V;
        private List<List<Integer>> adjList;

        public Graph(int V) {
            this.V = V;
            this.adjList = new ArrayList<>();

            for (int i = 0; i < this.V; i++) {
                this.adjList.add(new ArrayList<>());
            }
        }

        public void addEdge(int u, int v) {
            this.adjList.get(u).add(v);
        }

        public boolean isCyclic() {
            Set<Integer> seen = new HashSet<>();
            Set<Integer> recStack = new HashSet<>();

            for (int i = 0; i < V; i++) {
                if (seen.contains(i)) {
                    continue;
                }

                if (isCyclicUtil(i, seen, recStack)) {
                    return true;
                }
            }

            return false;
        }

        public List<Integer> topSort() {
            Set<Integer> seen = new HashSet<>();
            Stack<Integer> st = new Stack<>();

            for (int i = 0; i < this.V; i++) {
                if (seen.contains(i)) {
                    continue;
                }

                topSortUtil(i, seen, st);
            }

            var result = new ArrayList<Integer>();
            while(!st.empty()) {
                var x = st.pop();
                result.add(x);
            }
            return result;
        }

        private void topSortUtil(int v, Set<Integer> seen, Stack<Integer> st) {
            seen.add(v);
            var neighbors = this.adjList.get(v);

            for (var x : neighbors) {
                if(seen.contains(x)) {
                    continue;
                }

                topSortUtil(x, seen, st);
            }

            // push when v is completely explored.
            st.push(v);
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

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) {
            return new int[]{};
        }

        Graph g = new Graph(numCourses);

        for (int i = 0; i < prerequisites.length; i++) {
            var u = prerequisites[i][0];
            var v = prerequisites[i][1];

            g.addEdge(v, u);
        }

        if (g.isCyclic()) {
            return new int[]{};
        }

        var order = g.topSort();
        return order.stream().mapToInt(x -> x).toArray();
    }
}
