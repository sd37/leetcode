// https://leetcode.com/problems/first-bad-version/description/
// Solution = AC
package com.leetcode.main.solution;

public class FirstBadVersion {
  public int firstBadVersion(int n) {
    int l = 1;
    int r = n;

    int mid = -1;
    while(l <= r) {
      mid = l + (r - l) / 2;

      if(!isBadVersion(mid) && mid + 1 <= n && isBadVersion(mid + 1)) {
        return mid + 1;
      } else if(isBadVersion(mid)) {
        r = mid - 1;
      } else {
        l = mid + 1;
      }
    }

    // if everything is bad.
    return mid;
  }

  boolean isBadVersion(int version) {
    return false;
  }
}
