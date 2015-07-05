package com.leetcode.test.solution;

import com.leetcode.common.ListNode;
import com.leetcode.main.solution.RemoveLinkedListElements;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestRemoveLinkedListElements {

  private static RemoveLinkedListElements soln;

  @BeforeClass
  public static void setUp() {
    soln = new RemoveLinkedListElements();
  }

  @Test
  public void testRemoveLLElement() {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);

    soln.removeElements(head, 3);
    soln.removeElements(head, 4);

    Assert.assertEquals(2,soln.removeElements(head, 1).val);
  }
}
