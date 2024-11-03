// https://leetcode.com/problems/count-of-range-sum/description/
// Status = AC

/*
Given an integer array nums and two integers lower and upper, return the number of range sums that lie in [lower, upper] inclusive.

Range sum S(i, j) is defined as the sum of the elements in nums between indices i and j inclusive, where i <= j.



Example 1:

Input: nums = [-2,5,-1], lower = -2, upper = 2
Output: 3
Explanation: The three ranges are: [0,0], [2,2], and [0,2] and their respective sums are: -2, -1, 2.
Example 2:

Input: nums = [0], lower = 0, upper = 0
Output: 1


Constraints:

1 <= nums.length <= 105
-231 <= nums[i] <= 231 - 1
-105 <= lower <= upper <= 105
The answer is guaranteed to fit in a 32-bit integer.
 */
package com.leetcode.main.solution;

import java.util.Arrays;

public class CountOfRangeSum {
    public int countRangeSum(int[] nums, int lower, int upper) {
        int[] fenwick = new int[nums.length + 1];
        Arrays.fill(fenwick, 0);

        for (int i = 1; i <= nums.length; i++) {
            this.add(fenwick, i, nums[i - 1]);
        }

        int count = 0;
        for (int i = 1; i < fenwick.length; i++) {
            var val = fenwick[i];

            if (lower <= val && val <= upper) {
                count++;
            }
        }

        return count;
    }

    private int query(int[] fenwick, int i) {
        int res = 0;

        while (i > 0) {
            res += fenwick[i];
            i -= lsb(i);
        }

        return res;
    }

    private void add(int[] fenwick, int i, int diff) {
        while (i < fenwick.length) {
            fenwick[i] += diff;
            i += lsb(i);
        }
    }

    private int lsb(int x) {
        return x & -x;
    }
}
