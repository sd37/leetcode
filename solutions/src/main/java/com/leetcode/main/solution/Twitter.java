package com.leetcode.main.solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Twitter {
  private Map<Integer, List<Integer>> userToTweets;
  private Map<Integer, Set<Integer>> userToFollowees;

  /** Initialize your data structure here. */
  public Twitter() {
    userToTweets = new HashMap<>();
    userToFollowees = new HashMap<>();
  }

  /** Compose a new tweet. */
  public void postTweet(int userId, int tweetId) {
    if(!userToTweets.containsKey(userId)) {
      userToTweets.put(userId, new ArrayList<>());
    }

    userToTweets.get(userId).add(userId);
  }

  /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
  public List<Integer> getNewsFeed(int userId) {
    return null;
  }

  /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
  public void follow(int followerId, int followeeId) {
    if(!userToTweets.containsKey(followeeId) || !userToTweets.containsKey(followeeId)) {
      return;
    }

    if(!userToFollowees.containsKey(followerId)) {
      userToFollowees.put(followerId, new HashSet<>());
    }

    userToFollowees.get(followerId).add(followeeId);
  }

  /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
  public void unfollow(int followerId, int followeeId) {
    if(!userToTweets.containsKey(followeeId) || !userToTweets.containsKey(followeeId)) {
      return;
    }

    if(userToFollowees.containsKey(followerId)) {
      userToFollowees.get(followerId).remove(followeeId);
    }
  }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
