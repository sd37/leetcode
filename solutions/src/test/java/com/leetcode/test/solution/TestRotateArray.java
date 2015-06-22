package com.leetcode.test.solution;

import com.leetcode.main.solution.RotateArray;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;

public class TestRotateArray {

  private static RotateArray soln;

  @BeforeClass
  public static void setUp() {
    soln = new RotateArray();
  }

  @Test
  public void testRotateArray() {
    int[] arr = new int[]{1,2,3,4,5,6,7};
    soln.rotate(arr, 3);
    int[] arrRotate = new int[]{5,6,7,1,2,3,4};
    Assert.assertTrue(Arrays.equals(arrRotate, arr));
  }
}
