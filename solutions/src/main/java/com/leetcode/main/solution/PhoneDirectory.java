// https://leetcode.com/problems/design-phone-directory/description/
// Status = AC
// Read about linkedHashSet add, remove, contains operations are in constant time.

package com.leetcode.main.solution;

import java.util.LinkedHashSet;

public class PhoneDirectory {
  private LinkedHashSet<Integer> phoneSet;

  /**
   * Initialize your data structure here
   *
   * @param maxNumbers - The maximum numbers that can be stored in the phone directory.
   */
  public PhoneDirectory(int maxNumbers) {
    phoneSet = new LinkedHashSet<>(maxNumbers);

    for (int i = 0; i < maxNumbers; i++) {
      phoneSet.add(i);
    }
  }

  /**
   * Provide a number which is not assigned to anyone.
   *
   * @return - Return an available number. Return -1 if none is available.
   */
  public int get() {
    if(phoneSet.isEmpty()) {
      return -1;
    }

    Integer x = phoneSet.iterator().next();
    phoneSet.remove(x);
    return x;
  }

  /**
   * Check if a number is available or not.
   */
  public boolean check(int number) {
    return phoneSet.contains(number);
  }

  /**
   * Recycle or release a number.
   */
  public void release(int number) {
    phoneSet.add(number);
  }
}

/**
 * Your PhoneDirectory object will be instantiated and called as such: PhoneDirectory obj = new
 * PhoneDirectory(maxNumbers); int param_1 = obj.get(); boolean param_2 = obj.check(number);
 * obj.release(number);
 */
