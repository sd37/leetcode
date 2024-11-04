package com.leetcode.test.solution;

import com.leetcode.common.TreeNode;
import com.leetcode.main.solution.BinaryTreeRightSideView;
import com.leetcode.main.solution.ExclusiveTimeOfFunctions;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestExclusiveTimeOfFunctions {
    private static ExclusiveTimeOfFunctions soln;

    @BeforeClass
    public static void setUp() {
        soln = new ExclusiveTimeOfFunctions();
    }

    @Test
    public void testExclusiveTimeOffFunctions() {
        List<String> logs = Arrays.asList("0:start:0","1:start:2","1:end:5","0:end:6");
        var result = soln.exclusiveTime(2, logs);
        Assert.assertNotNull(result);
    }
}
