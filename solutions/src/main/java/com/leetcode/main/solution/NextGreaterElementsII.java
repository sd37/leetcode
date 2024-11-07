// Status = AC
// https://leetcode.com/problems/next-greater-element-ii/description/
/*
Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]), return the next greater number for every element in nums.

The next greater number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, return -1 for this number.



Example 1:

Input: nums = [1,2,1]
Output: [2,-1,2]
Explanation: The first 1's next greater number is 2;
The number 2 can't find next greater number.
The second 1's next greater number needs to search circularly, which is also 2.
Example 2:

Input: nums = [1,2,3,4,3]
Output: [2,3,4,-1,4]


Constraints:

1 <= nums.length <= 104
-109 <= nums[i] <= 109
 */
// Solution: Monotonic stack. Circular array: create array of 2 times of original size.
package com.leetcode.main.solution;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class NextGreaterElementsII {
    public int[] nextGreaterElements(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new RuntimeException("Bad input");
        }

        int[] newNums = IntStream.concat(IntStream.of(nums), IntStream.of(nums)).toArray();

        Map<Integer, Integer> resultMap = new TreeMap<>();
        Stack<Integer> st = new Stack<>();

        for (int i = newNums.length - 1; i >= 0; i--) {
            var currElem = newNums[i];

            while (!st.empty()) {
                var top = st.peek();
                if (currElem < top) {
                    resultMap.put(i, top);
                    st.push(currElem);
                    break;
                }

                st.pop();
            }

            if (st.empty()) {
                resultMap.put(i, -1);
                st.push(currElem);
            }
        }

        return resultMap.keySet().stream().limit(nums.length).mapToInt(resultMap::get).toArray();
    }
}
