import java.util.*;

public class ExclusiveTimeOfFunctions {
  public class Log {
    int id;
    boolean isStart;
    int time;

    public Log(String content) {
      String[] temp = content.split(":");
      this.id = Integer.valueOf(temp[0]);
      this.isStart = temp[1].equals("start");
      this.time = Integer.valueOf(temp[2]);
    }
  }

  public int[] exclusiveTime(int n, List<String> logs) {
    Stack<Log> st = new Stack<>();
    int[] ans = new int[n];
    for (String curr : logs) {
      Log log = new Log(curr);
      if (log.isStart) {
        st.push(log);
      } else {
        Log top = st.pop();
        int time = log.time - top.time + 1;
        ans[top.id] += time;
        if (!st.isEmpty()) {
          ans[st.peek().id] -= time;
        }
      }
    }
    return ans;
  }
}
