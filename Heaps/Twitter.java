import java.util.*;

public class Twitter {
  List<Message> timeFeed;
  Map<Integer, Set<Integer>> graph;

  public Twitter() {
    timeFeed = new ArrayList<>();
    graph = new HashMap<>();
  }

  public void postTweet(int userId, int tweetId) {
    timeFeed.add(new Message(userId, tweetId));
  }

  public List<Integer> getNewsFeed(int userId) {
    List<Integer> result = new ArrayList<>();
    Set<Integer> followees = graph.getOrDefault(userId, Collections.emptySet());

    for (int i = timeFeed.size() - 1; i >= 0 && result.size() < 10; i--) {
      Message msg = timeFeed.get(i);
      if (msg.userId == userId || followees.contains(msg.userId))
        result.add(msg.tweetId);
    }
    return result;
  }

  public void follow(int followerId, int followeeId) {
    graph.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
  }

  public void unfollow(int followerId, int followeeId) {
    graph.computeIfPresent(followerId, (k, v) -> {
      v.remove(followeeId);
      return v;
    });
  }

  private static class Message {
    int userId, tweetId;

    public Message(int userId, int tweetId) {
      this.userId = userId;
      this.tweetId = tweetId;
    }
  }
}