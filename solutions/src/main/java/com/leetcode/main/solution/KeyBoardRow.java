// https://leetcode.com/problems/keyboard-row/description/
// Status = AC
package com.leetcode.main.solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KeyBoardRow {

  private Map<Character, Integer> chToRow;

  public KeyBoardRow() {
    chToRow = new HashMap<>();
    String s1 = "qwertyuiop";
    for (char ch : s1.toCharArray()) {
      chToRow.put(ch, 1);
    }

    String s2 = "asdfghjkl";

    for (char ch : s2.toCharArray()) {
      chToRow.put(ch, 2);
    }

    String s3 = "zxcvbnm";

    for (char ch : s3.toCharArray()) {
      chToRow.put(ch, 3);
    }

  }

  public String[] findWords(String[] words) {
    List<String> res = new ArrayList<>();

    if (words == null || words.length == 0) {
      return res.toArray(new String[res.size()]);
    }

    for (String w : words) {
      if (sameRow(w.toLowerCase())) {
        res.add(w);
      }
    }

    return res.toArray(new String[res.size()]);
  }

  private boolean sameRow(String word) {
    for (int i = 0; i < word.length() - 1; i++) {
      char currCh = word.charAt(i);
      char nextCh = word.charAt(i + 1);

      if(chToRow.get(currCh) != chToRow.get(nextCh)) {
        return false;
      }
    }
    return true;
  }
}
