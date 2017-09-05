// https://leetcode.com/problems/judge-route-circle/description/
// status = Accepted.

package com.leetcode.main.solution;

import java.util.HashMap;
import java.util.Map;

public class JudgeRouteCircle {

  public boolean judgeCircle(String moves) {
    moves = moves.toUpperCase();
    if (moves == null || moves.isEmpty()) {
      return true;
    }

    Map<Character, Integer> charToCount = new HashMap<>();

    for (char ch : moves.toCharArray()) {
      if (!charToCount.containsKey(ch)) {
        charToCount.put(ch, 0);
      }
      charToCount.put(ch, charToCount.get(ch) + 1);
    }


    int ups = getIntegerValue(charToCount.get('U'));
    int downs = getIntegerValue(charToCount.get('D'));
    int rights = getIntegerValue(charToCount.get('R'));
    int lefts = getIntegerValue(charToCount.get('L'));

    if ((ups == downs) && (lefts == rights)) {
      return true;
    }

    return false;
  }

  private int getIntegerValue(Integer x) {
    if(x == null) {
      return 0;
    }

    return x.intValue();
  }
}
