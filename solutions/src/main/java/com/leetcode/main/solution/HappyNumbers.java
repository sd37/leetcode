// https://leetcode.com/problems/happy-number/description/
// Status = AC

package com.leetcode.main.solution;

import java.util.HashSet;
import java.util.Set;

public class HappyNumbers {
  public boolean isHappy(int n) {
    Set<Integer> s = new HashSet<>();

    while(true) {
      int x = squareOfDigitSum(n);
      if(x == 1) {
        return true;
      }

      if(s.contains(x)) {
        return false;
      }

      s.add(x);
      n = x;
    }
  }

  private int squareOfDigitSum(int n) {
    int res = 0;

    if(n == 0) {
      return res;
    }

    while(n != 0) {
      int digit = n % 10;
      res += digit * digit;
      n /= 10;
    }

    return res;
  }
}
