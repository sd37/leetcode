// https://leetcode.com/problems/longest-word-in-dictionary/discuss/
// Status = AC

package com.leetcode.main.solution;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class LongestWordInDictionary {

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

    String words[];
    private TrieNode root;

    public Trie(String[] words) {
      root = new TrieNode('0');
      this.words = words;
    }

    public void insert(String word, int index) {
      if (word == null) {
        return;
      }

      TrieNode curr = root;

      for (int i = 0; i < word.length(); i++) {
        char ch = word.charAt(i);
        curr.childs.putIfAbsent(ch, new TrieNode(ch));

        curr = curr.childs.get(ch);
      }

      curr.end = index;
    }

    public String dfs() {
      String ans = "";
      Stack<TrieNode> st = new Stack<>();

      st.push(root);

      while (!st.isEmpty()) {
        TrieNode x = st.pop();

        if (x.end > 0 && x != root) {
          String word = words[x.end - 1];

          if (word.length() > ans.length() || (word.length() == ans.length()
              && word.compareTo(ans) < 0)) {
            ans = word;
          }
        }

        if (x.end > 0 || x == root) {
          for (Character ch : x.childs.keySet()) {
            TrieNode child = x.childs.get(ch);
            st.push(child);
          }
        }

      }

      return ans;
    }
  }

  public String longestWordTrie(String[] words) {
    if (words == null || words.length == 0) {
      return "";
    }

    Trie tr = new Trie(words);
    int index = 0;

    for (String word : words) {
      tr.insert(word, ++index); // start from 1
    }

    return tr.dfs();
  }

  public String longestWord(String[] words) {
    Arrays.sort(words);
    Set<String> built = new HashSet<String>();
    String res = "";
    // note you have to build it sequentially!!
    for (String w : words) {
      if (w.length() == 1 || built.contains(w.substring(0, w.length() - 1))) {
        res = w.length() > res.length() ? w : res;
        built.add(w);
      }
    }
    return res;
  }
}
