// https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
// Status = AC
package com.leetcode.main.solution;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfPhoneNumber {

  private static final String[] KEYS = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv",
      "wxyz"};

  public List<String> letterCombinations(String digits) {
    if (digits == null) {
      throw new RuntimeException("Invalid digits!");
    }

    List<String> ans = new ArrayList<>();

    if(digits.length() == 0) {
      return ans;
    }

    letterCombUtil(digits, ans, "", 0);

    return ans;
  }

  private void letterCombUtil(String digits, List<String> ans, String res, int offset) {
    if (res.length() == digits.length()) {
      ans.add(res);
      return;
    }

    int chI = Character.getNumericValue(digits.charAt(offset));
    String options = KEYS[chI];

    for (int i = 0; i < options.length(); i++) {
      char ch = options.charAt(i);
      letterCombUtil(digits, ans, res + Character.toString(ch), offset + 1);
    }
  }
}
