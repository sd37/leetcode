// https://leetcode.com/problems/compare-version-numbers/description/
// Status = AC
package com.leetcode.main.solution;

public class CompareVersionNumber {
  public int compareVersion(String v1, String v2) {
    if(v1 == null || v2 == null || "".equals(v1) || "".equals(v2)) {
      throw new RuntimeException("Invalid version numbers");
    }

    String[] v1Levels = v1.split("\\.");
    String[] v2Levels = v2.split("\\.");

    int n = Math.max(v1Levels.length, v2Levels.length);

    for(int i = 0; i < n; i++) {
      int numV1 = i < v1Levels.length ? Integer.parseInt(v1Levels[i]) : 0;
      int numV2 = i < v2Levels.length ? Integer.parseInt(v2Levels[i]) : 0;

      int res = Integer.compare(numV1, numV2);

      if(res != 0) {
        return res;
      }
    }

    return 0;
  }
}
