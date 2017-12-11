package com.leetcode.main.solution;

public class ValidPerfectSquare {

  public boolean isPerfectSquare(int num) {
    int i;
    for (i = 1; i * i < num; i++) {

    }

    if (i * i == num) {
      return true;
    }

    return false;
  }
}
