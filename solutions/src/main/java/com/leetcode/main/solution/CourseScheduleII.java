// https://leetcode.com/problems/course-schedule-ii/description/
// Status = AC

/*
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.



Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: [0,1]
Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1].
Example 2:

Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
Output: [0,2,1,3]
Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].
Example 3:

Input: numCourses = 1, prerequisites = []
Output: [0]


Constraints:

1 <= numCourses <= 2000
0 <= prerequisites.length <= numCourses * (numCourses - 1)
prerequisites[i].length == 2
0 <= ai, bi < numCourses
ai != bi
All the pairs [ai, bi] are distinct.
 */

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
