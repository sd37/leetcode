// https://leetcode.com/problems/generate-parentheses/description/
// Status = AC
package com.leetcode.main.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class GenerateParenthesis {
  private List<Character> options = Arrays.asList('(', ')');

  public List<String> generateParenthesis(int n) {
    List<String> res = new ArrayList<>();

    if(n == 0) {
      return res;
    }

    genParenUtil("", 2 * n, res);
    return res;
  }

  private void genParenUtil(String s, int len, List<String> res) {
    if(s.length() == len) {
      if(isValidParens(s)) {
        res.add(s);
      }
      return;
    }

    for (char opt : options) {
      genParenUtil(s + opt, len, res);
    }
  }

  private boolean isValidParens(String s) {
    if(s == null || "".equals(s)) {
      return true;
    }

    Stack<Character> st = new Stack<>();

    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);

      if(!st.isEmpty() && isOpp(st.peek(), ch)) {
        st.pop();
      } else{
        st.push(ch);
      }
    }

    return st.isEmpty();
  }

  private boolean isOpp(char x, char y) {
    return (x == '(' && y == ')');
  }
}
