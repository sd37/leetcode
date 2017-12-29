package com.leetcode.test.solution;

import com.leetcode.main.solution.FindAllAnagrams;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestFindAllAnagrams {

  private static FindAllAnagrams soln;

  @BeforeClass
  public static void setUp() {
    soln = new FindAllAnagrams();
  }

  @Test
  public void testFindAllAnagrams() {
    soln.findAnagrams("cbaebabacd", "abc");
  }
}

