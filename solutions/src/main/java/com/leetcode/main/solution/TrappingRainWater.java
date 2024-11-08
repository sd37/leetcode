// https://leetcode.com/problems/trapping-rain-water/description/
// status = AC
/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.



Example 1:


Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
Example 2:

Input: height = [4,2,0,3,2,5]
Output: 9


Constraints:

n == height.length
1 <= n <= 2 * 104
0 <= height[i] <= 105
 */
package com.leetcode.main.solution;

import java.util.*;

public class TrappingRainWater {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int totalWater = 0;
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < height.length; i++) {
            var currElem = height[i];

            // pop all smaller than currElem
            while (!st.empty() && height[st.peek()] < currElem) {
                int popHeight = height[st.pop()];
                if(st.empty()) {
                    break;
                }

                int dist = i - st.peek() - 1;
                int boundedH = Math.min(currElem, height[st.peek()]) - popHeight;

                totalWater += dist * boundedH;
            }

            st.push(i);
        }

        return totalWater;
    }
}
