package com.leetcode.test.solution;

import com.leetcode.main.solution.CountOfRangeSum;
import com.leetcode.main.solution.CourseScheduleIV;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestCourseScheduleIV {
    private static CourseScheduleIV soln;

    @BeforeClass
    public static void setUp() {
        soln = new CourseScheduleIV();
    }

    @Test
    public void testCourseScheduleIV() {
        int numCourses = 2;
        int[][] prerequisites = new int[][] { {1,0} };
        int[][] queries = new int[][] { {0,1}, {1,0} };

        var result = soln.checkIfPrerequisite(numCourses, prerequisites, queries);
        Assert.assertNotNull(result);
    }
}
