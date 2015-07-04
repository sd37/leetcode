/**
 * https://leetcode.com/problems/count-primes/
 * Status = Accepted
 */

package com.leetcode.main.solution;

public class CountPrimes {
  public int countPrimes(int n) {
    if (n < 0) {
      throw new RuntimeException();
    }

    if (n < 2) {
      return 0;
    }

    boolean[] primes = new boolean[n];

    for (int i = 2; i < primes.length; i++) {
      primes[i] = true;
    }

    for (int i = 2; i*i < n; i++) {
      if (primes[i] == true) {
        for (int j = i * i; j < n; j = j + i) {
          primes[j] = false;
        }
      }
    }

    int count = 0;

    for (int i = 2; i < n; i++) {
      if (primes[i] == true) {
        count++;
      }
    }
    return count;
  }
}
