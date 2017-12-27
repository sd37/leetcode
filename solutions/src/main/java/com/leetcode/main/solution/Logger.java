// https://leetcode.com/problems/logger-rate-limiter/description/
// Status = AC

package com.leetcode.main.solution;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

class Logger {

  Map<String, Integer> map;

  /**
   * Initialize your data structure here.
   */
  public Logger() {
    this.map = new ConcurrentHashMap<>();
  }

  /**
   * Returns true if the message should be printed in the given timestamp, otherwise returns false.
   * If this method returns false, the message will not be printed. The timestamp is in seconds
   * granularity.
   */
  public boolean shouldPrintMessage(int timestamp, String message) {
    if (!map.containsKey(message)) {
      map.put(message, timestamp);
      return true;
    }

    int diff = timestamp - map.get(message);

    if (diff >= 10) {
      map.put(message, timestamp);
      return true;
    }

    return false;
  }
}

/**
 * Your Logger object will be instantiated and called as such: Logger obj = new Logger(); boolean
 * param_1 = obj.shouldPrintMessage(timestamp,message);
 */
