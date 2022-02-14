import java.util.*;

public class Third {
  public class Server implements Comparable<Server> {
    int weight;
    int index;
    int time;

    public Server(int weight, int index, int time) {
      this.weight = weight;
      this.index = index;
      this.time = time;
    }

    @Override
    public int compareTo(Server o) {
      if (this.weight == o.weight) {
        return this.index - o.index;
      }
      return this.weight - o.weight;
    }
  }

  public int[] assignTasks(int[] servers, int[] tasks) {
    PriorityQueue<Server> free = new PriorityQueue<>();
    PriorityQueue<Server> inUse = new PriorityQueue<>(
        (a, b) -> a.time == b.time ? a.compareTo(b) : a.time - b.time);
    int[] ans = new int[tasks.length];
    for (int i = 0; i < servers.length; i++) {
      free.offer(new Server(servers[i], i, 0));
    }

    for (int i = 0; i < tasks.length; i++) {
      while (!inUse.isEmpty() && inUse.peek().time <= i) {
        free.offer(inUse.poll());
      }
      if (!free.isEmpty()) {
        Server curr = free.poll();
        curr.time = curr.time + tasks[i];
        inUse.offer(curr);
        ans[i] = curr.index;
      } else {
        Server curr = inUse.poll();
        curr.time = curr.time + tasks[i];
        inUse.offer(curr);
        ans[i] = inUse.peek().index;
      }
    }
    return ans;
  }
}