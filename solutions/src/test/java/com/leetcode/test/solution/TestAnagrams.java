package com.leetcode.test.solution;

import com.leetcode.main.solution.Anagrams;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

public class TestAnagrams {
  private static Anagrams soln;

  @BeforeClass
  public static void setUp() {
    soln = new Anagrams();
  }

  @Test
  public void testAnagram() {
    String[] arrString = new String[]{"and", "dan", "spandan", "nadnaps"};
    List<String> anagrams = soln.anagrams(arrString);
    Assert.assertTrue(anagrams.contains("and"));
    Assert.assertTrue(anagrams.contains("dan"));
    Assert.assertTrue(anagrams.contains("spandan"));
    Assert.assertTrue(anagrams.contains("nadnaps"));
  }
}
