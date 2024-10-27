package com.leetcode.test.solution;

import com.leetcode.main.solution.MinGeneticMutation;
import com.leetcode.main.solution.ValidNumber;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestMinGeneticMutation {

    private static MinGeneticMutation soln;

    @BeforeClass
    public static void setUp() {
        soln = new MinGeneticMutation();
    }

    @Test
    public void testMinGeneticMutation() {
        String startGene = "AACCGGTT";
        String endGene = "AAACGGTA";
        String[] bank = new String[] { "AACCGGTA","AACCGCTA","AAACGGTA" };

        Assert.assertEquals(2, soln.minMutation(startGene, endGene, bank));
    }
}
