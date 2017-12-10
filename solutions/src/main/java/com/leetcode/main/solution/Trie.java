// https://leetcode.com/problems/implement-trie-prefix-tree/description/
// Status = AC
package com.leetcode.main.solution;

import java.util.HashMap;
import java.util.Map;

public class Trie {
  class TrieNode {
    private char ch;
    private int end;

    private Map<Character, TrieNode> childs;

    public TrieNode(char ch) {
      this.ch = ch;
      this.childs = new HashMap<>();
    }
  }

  private TrieNode root;

  public Trie() {
    root = new TrieNode('0');
  }

  /** Inserts a word into the trie. */
  public void insert(String word) {
    if(word == null) {
      return;
    }

    TrieNode curr = root;

    for(int i = 0; i < word.length(); i++) {
      char ch = word.charAt(i);
      curr.childs.putIfAbsent(ch, new TrieNode(ch));
      curr = curr.childs.get(ch);
    }

    curr.end++;
  }

  /** Returns if the word is in the trie. */
  public boolean search(String word) {
    if(word == null) {
      return false;
    }

    TrieNode curr = root;
    for (int i = 0; i < word.length(); i++) {
      char ch = word.charAt(i);
      if(curr == null) {
        break;
      }
      curr = curr.childs.get(ch);
    }

    return (curr != null && curr.end != 0);
  }

  /** Returns if there is any word in the trie that starts with the given prefix. */
  public boolean startsWith(String prefix) {
    if(prefix == null) {
      return false;
    }

    TrieNode curr = root;
    for (int i = 0; i < prefix.length(); i++) {
      char ch = prefix.charAt(i);
      if(curr == null) {
        break;
      }
      curr = curr.childs.get(ch);
    }

    return curr != null;
  }
}
