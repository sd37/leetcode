// https://leetcode.com/problems/nth-digit/description/
// Status = AC
package com.leetcode.main.solution;

public class NthDigit {
  public int findNthDigit(int n) {
    long factor = 10;
    long store = 9;
    long digitSize = 1;

    while (true) {
      if ((n - digitSize * store) <= 0) {
        break;
      }
      n -= digitSize * store;
      store *= factor;
      digitSize++;
    }

    long expectedNum;
    expectedNum = ((long) Math.pow(factor, digitSize - 1) - 1) + (n / digitSize);
    if (n % digitSize == 0) {
      String expectedNumS = Long.toString(expectedNum);
      return Character.getNumericValue(expectedNumS.charAt(expectedNumS.length() - 1));
    } else {
      expectedNum++;
      String expectedNumS = Long.toString(expectedNum);
      return Character.getNumericValue(expectedNumS.charAt((int)(n % digitSize - 1)));
    }
  }
}
