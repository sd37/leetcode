// https://leetcode.com/problems/next-greater-element-iii
// Status = AC

/*
Given a positive integer n, find the smallest integer which has exactly the same digits existing in the integer n and is greater in value than n. If no such positive integer exists, return -1.

Note that the returned integer should fit in 32-bit integer, if there is a valid answer but it does not fit in 32-bit integer, return -1.



Example 1:

Input: n = 12
Output: 21
Example 2:

Input: n = 21
Output: -1


Constraints:

1 <= n <= 231 - 1
 */

// have a pointer at end and traverse till you find inflextion point in incresing order.
// find the next greatest element of that inflextion point by traversing from end.
// swap that element with infextion point and sort rest after inflexion point.

package com.leetcode.main.solution;

import java.util.*;

public class NextGreaterElementIII {

    public int nextGreaterElement(int n) {
        String ns = Integer.toString(n);
        int[] digits = ns.chars().map(Character::getNumericValue).toArray();

        int curIndex = digits.length - 1;
        int prevIndex = curIndex - 1;

        while (prevIndex >= 0) {
            if (digits[prevIndex] < digits[curIndex]) {
                break;
            }

            curIndex = prevIndex;
            prevIndex--;
        }

        // array is sorted in decreasing order.
        if(prevIndex < 0) {
            return -1;
        }

        var nextGreatesti = -1;
        for (int i = digits.length - 1; i > prevIndex; i--) {
            if (digits[i] > digits[prevIndex]) {
                nextGreatesti = i;
                break;
            }
        }

        swap(digits, prevIndex, nextGreatesti);
        Arrays.sort(digits, prevIndex + 1, digits.length);

        String ds = Arrays.stream(digits).mapToObj(Integer::toString).reduce((a,b) -> a + b).get();
        try {
            return Integer.parseInt(ds);
        } catch (Exception ex) {
            return -1;
        }
    }

    private void swap(int[] a, int i, int j) {
        var temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
