package com.leetcode.test.solution;

import com.leetcode.main.solution.ClimbStairs;
import com.leetcode.main.solution.LongestSubstring;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestLongestSubstringWithoutRepeatingChars {
    private static LongestSubstring soln;

    @BeforeClass
    public static void setUp() {
        soln = new LongestSubstring();
    }

    @Test
    public void testLongestSubstring() {
        int res = soln.lengthOfLongestSubstring2("abcabcbb");
        Assert.assertEquals(3, res);

        res = soln.lengthOfLongestSubstring2("pwwkew");
        Assert.assertEquals(3, res);

        res = soln.lengthOfLongestSubstring2("abba");
        Assert.assertEquals(2, res);
    }
}
