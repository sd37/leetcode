// https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
// Status = AC
// TC = O(n^2)
// SC = O(n)

/*
iven a string s, find the length of the longest
substring
 without repeating characters.



Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
*/

package com.leetcode.main.solution;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        if (s.length() == 1) {
            return 1;
        }

        Set<Character> seen = new HashSet<>();
        int longestSubstr = Integer.MIN_VALUE;
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            count = 0;
            for (int j = i; j < s.length(); j++) {
                if (seen.contains(s.charAt(j))) {
                    break;
                }
                seen.add(s.charAt(j));
                count++;
            }
            longestSubstr = Math.max(longestSubstr, count);
            seen.clear();
        }

        return longestSubstr;
    }

    // sliding window algo.
    // TC = O(N)
    public int lengthOfLongestSubstring2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        if (s.length() == 1) {
            return 1;
        }

        int maxCount = 0;
        Map<Character, Integer> seen = new HashMap<>();

        // compute initial window
        for (int windowStart = 0, windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            var chi = s.charAt(windowEnd);
            if (seen.containsKey(s.charAt(windowEnd))) {
                var windowStartNew = seen.get(chi) + 1;
                while(windowStart < windowStartNew)
                {
                    seen.remove(s.charAt(windowStart));
                    windowStart++;
                }
            }

            int currSize = windowEnd - windowStart + 1;
            if (currSize > maxCount) {
                maxCount = currSize;
            }

            seen.put(chi, windowEnd);
        }

        return maxCount;
    }
}
