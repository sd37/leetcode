// https://leetcode.com/problems/map-sum-pairs/description/
// Status = AC

package com.leetcode.main.solution;

import java.util.HashMap;
import java.util.Map;

public class MapSum {

  class TrieNode {

    private char ch;
    private int end;
    private Map<Character, TrieNode> childs;

    public TrieNode(char ch) {
      this.ch = ch;
      this.childs = new HashMap<>();
    }
  }

  class Trie {

    private TrieNode root;

    public Trie() {
      root = new TrieNode('0');
    }

    public void insert(String key, int val) {
      if (key == null) {
        return;
      }

      TrieNode curr = root;
      for (int i = 0; i < key.length(); i++) {
        char ch = key.charAt(i);
        curr.childs.putIfAbsent(ch, new TrieNode(ch));
        curr = curr.childs.get(ch);
      }

      curr.end = val;
    }

    public int sum(String prefix) {
      if (prefix == null) {
        return 0;
      }

      TrieNode curr = root;
      for (int i = 0; i < prefix.length(); i++) {
        char ch = prefix.charAt(i);
        if(curr == null) {
          break;
        }
        curr = curr.childs.get(ch);
      }

      int resSum = 0;

      if(curr != null) {
        resSum = dfsUtil(curr);
      }

      return resSum;
    }

    private int dfsUtil(TrieNode curr) {
      int interSum = curr.end;
      for (char ch: curr.childs.keySet()) {
        TrieNode next = curr.childs.get(ch);
        interSum += dfsUtil(next);
      }
      return interSum;
    }
  }

  /**
   * Initialize your data structure here.
   */

  private Trie tr;

  public MapSum() {
    tr = new Trie();
  }

  public void insert(String key, int val) {
    tr.insert(key, val);
  }

  public int sum(String prefix) {
    return tr.sum(prefix);
  }
}
