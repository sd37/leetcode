package com.leetcode.main.solution;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class RemoveDuplicateLetters {
  public String removeDuplicateLetters(String s) {
    if(s == null) {
      return s;
    }

    Set<Character> seen = new TreeSet<>();

    for(int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      if(!seen.contains(ch)) {
        seen.add(ch);
      }
    }

    StringBuilder res = new StringBuilder(s.length());

    Iterator<Character> it = seen.iterator();
    while(it.hasNext()) {
      res.append(it.next());
    }

    return new String(res);
  }
}
