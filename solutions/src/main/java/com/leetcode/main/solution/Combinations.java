// https://leetcode.com/problems/combinations/description/
// Status = AC
/*
Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].

You may return the answer in any order.



Example 1:

Input: n = 4, k = 2
Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
Explanation: There are 4 choose 2 = 6 total combinations.
Note that combinations are unordered, i.e., [1,2] and [2,1] are considered to be the same combination.
Example 2:

Input: n = 1, k = 1
Output: [[1]]
Explanation: There is 1 choose 1 = 1 total combination.


Constraints:

1 <= n <= 20
1 <= k <= n
 */
package com.leetcode.main.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();

        if (n == 0 || k == 0) {
            return result;
        }

        var choices = IntStream.rangeClosed(1, n).toArray();

        if (n == k) {
            result.add(Arrays.stream(choices).boxed().toList());
            return result;
        }

        combineUtils(k, 0, choices, new ArrayList<Integer>(), result);
        return result;
    }

    private void combineUtils(int k, int start, int[] choices, List<Integer> currList, List<List<Integer>> result) {
        if (currList.size() == k) {
            result.add(new ArrayList<>(currList));
            return;
        }

        for (int i = start; i < choices.length; i++) {
            currList.add(choices[i]);
            combineUtils(k, i + 1, choices, currList, result);
            currList.remove(currList.size() - 1);
        }
    }
}
