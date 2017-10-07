// https://leetcode.com/contest/leetcode-weekly-contest-51/problems/baseball-game/
// Status = AC

package com.leetcode.main.solution;

import java.util.Arrays;
import java.util.Stack;

public class CalPoints {

  public int calPoints(String[] ops) {
    String[] roundScore = new String[ops.length];
    Stack<Integer> validIndexs = new Stack<>();

    for (int i = 0; i < ops.length; i++) {
      String sym = ops[i];
      int score;
      int scoreChar;
      if (sym.equals("C")) {
        if(!validIndexs.isEmpty()) {
          roundScore[validIndexs.pop()] = "X";
        }
        roundScore[i] = "X";
      } else if (sym.equals("D")) {
        roundScore[i] = "0";
        if (i - 1 >= 0) {
          roundScore[i] = Integer.toString(2 * converToInt(roundScore[validIndexs.peek()]));
        }
        validIndexs.push(i);
      } else if(sym.equals("+")) {
          int last = converToInt(roundScore[validIndexs.get(validIndexs.size() - 1)]);
          int secondLast = converToInt(roundScore[validIndexs.get(validIndexs.size() - 2)]);
          roundScore[i] = Integer.toString(last + secondLast);
          validIndexs.push(i);
      } else {
        // continue
        roundScore[i] = sym;
        validIndexs.push(i);
      }
    }

    return Arrays.stream(roundScore).mapToInt(s -> converToInt(s)).sum();
  }

  private int converToInt(String s) {
    try {
      return Integer.parseInt(s);
    } catch (NumberFormatException e) {
      return 0;
    }
  }
}
