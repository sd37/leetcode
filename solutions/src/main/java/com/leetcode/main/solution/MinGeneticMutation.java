// https://leetcode.com/problems/minimum-genetic-mutation/description/
// Status = AC
/*
A gene string can be represented by an 8-character long string, with choices from 'A', 'C', 'G', and 'T'.

Suppose we need to investigate a mutation from a gene string startGene to a gene string endGene where one mutation is defined as one single character changed in the gene string.

For example, "AACCGGTT" --> "AACCGGTA" is one mutation.
There is also a gene bank bank that records all the valid gene mutations. A gene must be in bank to make it a valid gene string.

Given the two gene strings startGene and endGene and the gene bank bank, return the minimum number of mutations needed to mutate from startGene to endGene. If there is no such a mutation, return -1.

Note that the starting point is assumed to be valid, so it might not be included in the bank.



Example 1:

Input: startGene = "AACCGGTT", endGene = "AACCGGTA", bank = ["AACCGGTA"]
Output: 1
Example 2:

Input: startGene = "AACCGGTT", endGene = "AAACGGTA", bank = ["AACCGGTA","AACCGCTA","AAACGGTA"]
Output: 2


Constraints:

0 <= bank.length <= 10
startGene.length == endGene.length == bank[i].length == 8
startGene, endGene, and bank[i] consist of only the characters ['A', 'C', 'G', 'T'].
 */
package com.leetcode.main.solution;

import java.util.*;
import java.util.stream.Stream;

public class MinGeneticMutation {

    private static final List<Character> GENE_CHARSET = List.of('A', 'C', 'G', 'T');

    private class Pair {
        public String data;
        public int level;

        public Pair(String data, int level) {
            this.data = data;
            this.level = level;
        }
    }

    public int minMutation(String startGene, String endGene, String[] bank) {
        if (startGene == null || startGene.isBlank()) {
            return -1;
        }

        if (endGene == null || endGene.isBlank()) {
            return -1;
        }

        var bankSet = this.computeBankSet(bank);
        if (bankSet.isEmpty()) {
            return -1;
        }

        if (!bankSet.contains(endGene)) {
            return -1;
        }

        var q = new LinkedList<Pair>();
        var visited = new HashSet<String>();

        visited.add(startGene);
        q.add(new Pair(startGene, 0));

        while (!q.isEmpty()) {
            var curr = q.poll();

            if (curr.data.equals(endGene)) {
                return curr.level;
            }

            var mutations = this.getMutations(curr.data, bankSet);

            for (var mutation : mutations) {
                if (!visited.contains(mutation)) {
                    visited.add(mutation);
                    q.add(new Pair(mutation, curr.level + 1));
                }
            }
        }

        return -1;
    }

    private List<String> getMutations(String curr, Set<String> bankSet) {
        List<String> result = new ArrayList<>();
        var currChar = curr.toCharArray();
        for (int i = 0; i < currChar.length; i++) {
            for (char xch : GENE_CHARSET) {
                var ch = currChar[i];
                if (ch == xch) {
                    continue;
                }

                var newSeq = curr.substring(0, i) + xch + curr.substring(i + 1);
                if (bankSet.contains(newSeq)) {
                    result.add(newSeq);
                }
            }
        }

        return result;
    }

    private Set<String> computeBankSet(String[] bank) {
        var bankSet = new HashSet<String>();
        if (bank == null || bank.length == 0) {
            return bankSet;
        }

        bankSet.addAll(Arrays.asList(bank));
        return bankSet;
    }
}
