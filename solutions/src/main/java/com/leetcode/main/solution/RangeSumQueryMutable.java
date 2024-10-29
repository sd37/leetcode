// https://leetcode.com/problems/range-sum-query-mutable/description/
// status = AC
/*
Given an integer array nums, handle multiple queries of the following types:

Update the value of an element in nums.
Calculate the sum of the elements of nums between indices left and right inclusive where left <= right.
Implement the NumArray class:

NumArray(int[] nums) Initializes the object with the integer array nums.
void update(int index, int val) Updates the value of nums[index] to be val.
int sumRange(int left, int right) Returns the sum of the elements of nums between indices left and right inclusive (i.e. nums[left] + nums[left + 1] + ... + nums[right]).


Example 1:

Input
["NumArray", "sumRange", "update", "sumRange"]
[[[1, 3, 5]], [0, 2], [1, 2], [0, 2]]
Output
[null, 9, null, 8]

Explanation
NumArray numArray = new NumArray([1, 3, 5]);
numArray.sumRange(0, 2); // return 1 + 3 + 5 = 9
numArray.update(1, 2);   // nums = [1, 2, 5]
numArray.sumRange(0, 2); // return 1 + 2 + 5 = 8


Constraints:

1 <= nums.length <= 3 * 104
-100 <= nums[i] <= 100
0 <= index < nums.length
-100 <= val <= 100
0 <= left <= right < nums.length
At most 3 * 104 calls will be made to update and sumRange.
 */
// this.fenwick = new ArrayList<>(Collections.nCopies(nums.length + 1, 0));
// fenwick tree. Index i stores the range (i, j + 1) where j = remove last bit of i
package com.leetcode.main.solution;

import java.util.Arrays;

public class RangeSumQueryMutable {
    int[] fenwick;
    int[] nums;

    public RangeSumQueryMutable(int[] nums) {
        this.nums = nums;
        this.fenwick = new int[nums.length + 1];
        Arrays.fill(this.fenwick, 0);

        for (int i = 1; i <= nums.length; i++) {
            this.add(i, nums[i - 1]);
        }
    }

    public void update(int index, int val) {
        int diff = val - this.nums[index];
        this.add(index + 1, diff);
        this.nums[index] = val;
    }

    public int sumRange(int left, int right) {
        left++;
        right++;

        if (left == 1) {
            return query(right);
        }

        return query(right) - query(left - 1);
    }

    private int query(int i) {
        int res = 0;

        while (i > 0) {
            res += this.fenwick[i];
            i -= lsb(i);
        }

        return res;
    }

    private void add(int i, int diff) {
        while (i < this.fenwick.length) {
            this.fenwick[i] += diff;
            i += lsb(i);
        }
    }

    private int lsb(int x) {
        return x & -x;
    }
}
