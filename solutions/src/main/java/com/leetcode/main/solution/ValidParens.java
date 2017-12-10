package com.leetcode.main.solution;

import java.util.Stack;

public class ValidParens {
  public boolean isValid(String s) {
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
    return (x == '(' && y == ')' || x == '[' && y == ']' || x == '{' && y == '}');
  }
}
