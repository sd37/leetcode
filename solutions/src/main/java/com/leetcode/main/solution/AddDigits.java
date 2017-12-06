// https://leetcode.com/problems/add-digits/description/
// Status = AC

package com.leetcode.main.solution;

public class AddDigits {
  public int addDigits(int num) {
    while(true) {
      if(num / 10 == 0) {
        return num;
      }

      num = sumOfDigit(num);
    }
  }

  private int sumOfDigit(int n) {
    int res = 0;

    while(n != 0) {
      int digit = n % 10;
      res += digit;
      n /= 10;
    }

    return res;
  }
}
