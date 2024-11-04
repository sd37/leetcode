// https://leetcode.com/problems/course-schedule-iv/description/
// status = AC
/*
here are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course ai first if you want to take course bi.

For example, the pair [0, 1] indicates that you have to take course 0 before you can take course 1.
Prerequisites can also be indirect. If course a is a prerequisite of course b, and course b is a prerequisite of course c, then course a is a prerequisite of course c.

You are also given an array queries where queries[j] = [uj, vj]. For the jth query, you should answer whether course uj is a prerequisite of course vj or not.

Return a boolean array answer, where answer[j] is the answer to the jth query.



Example 1:


Input: numCourses = 2, prerequisites = [[1,0]], queries = [[0,1],[1,0]]
Output: [false,true]
Explanation: The pair [1, 0] indicates that you have to take course 1 before you can take course 0.
Course 0 is not a prerequisite of course 1, but the opposite is true.
Example 2:

Input: numCourses = 2, prerequisites = [], queries = [[1,0],[0,1]]
Output: [false,false]
Explanation: There are no prerequisites, and each course is independent.
Example 3:


Input: numCourses = 3, prerequisites = [[1,2],[1,0],[2,0]], queries = [[1,0],[1,2]]
Output: [true,true]


Constraints:

2 <= numCourses <= 100
0 <= prerequisites.length <= (numCourses * (numCourses - 1) / 2)
prerequisites[i].length == 2
0 <= ai, bi <= numCourses - 1
ai != bi
All the pairs [ai, bi] are unique.
The prerequisites graph has no cycles.
1 <= queries.length <= 104
0 <= ui, vi <= numCourses - 1
ui != vi
 */
// just do topsort on each i and reset seen and stack.
package com.leetcode.main.solution;

import java.util.*;

public class CourseScheduleIV {
    private class Graph {
        private final int V;
        private List<List<Integer>> adjList;

        public Graph(int V) {
            this.V = V;
            this.adjList = new ArrayList<>();

            for (int i = 0; i < V; i++) {
                this.adjList.add(new ArrayList<>());
            }
        }

        public void addEdge(int u, int v) {
            this.adjList.get(u).add(v);
        }

        public boolean IsCyclic() {
            Set<Integer> seen = new HashSet<>();
            Set<Integer> recStack = new HashSet<>();

            for (int i = 0; i < this.V; i++) {
                if (seen.contains(i)) {
                    continue;
                }

                if (IsCyclicUtil(i, seen, recStack)) {
                    return true;
                }
            }
            return false;
        }

        public Map<Integer, Set<Integer>> topSort() {
            Set<Integer> seen = new HashSet<>();
            Stack<Integer> st = new Stack<>();

            Map<Integer, Set<Integer>> ds = new HashMap<>();

            for (int i = 0; i < this.V; i++) {
                topSortUtil(i, seen, st);

                while (!st.empty()) {
                    var elm = st.pop();
                    if (!ds.containsKey(i)) {
                        ds.put(i, new HashSet<>());
                    }

                    if (i != elm) {
                        ds.get(i).add(elm);
                    }
                }

                seen.clear();
                st.clear();
            }

            return ds;
        }

        private void topSortUtil(int v, Set<Integer> seen, Stack<Integer> st) {
            seen.add(v);

            var neighbors = this.adjList.get(v);
            for (var x : neighbors) {
                if (seen.contains(x)) {
                    continue;
                }
                topSortUtil(x, seen, st);
            }

            st.push(v);
        }

        private boolean IsCyclicUtil(int v, Set<Integer> seen, Set<Integer> recStack) {
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

                if (IsCyclicUtil(x, seen, recStack)) {
                    return true;
                }
            }

            recStack.remove(v);
            return false;
        }
    }

    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<Boolean> result = new ArrayList<>();
        if (numCourses == 0) {
            throw new IllegalArgumentException("numcourses is 0");
        }

        Graph g = new Graph(numCourses);

        for (int i = 0; i < prerequisites.length; i++) {
            var u = prerequisites[i][0];
            var v = prerequisites[i][1];
            g.addEdge(u, v);
        }

        if (g.IsCyclic()) {
            throw new IllegalArgumentException("Graph has cycle!");
        }

        var ds = g.topSort();

        for (int i = 0; i < queries.length; i++) {
            var a = queries[i][0];
            var b = queries[i][1];

            var res = ds.get(a).contains(b);
            result.add(res);
        }

        return result;
    }
}
