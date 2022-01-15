import java.util.*;

public class JumpGameVII {
  public boolean canReach(String s, int minJump, int maxJump) {
    Queue<Integer> qu = new LinkedList<>();
    qu.add(0);
    int max = 0;
    while (!qu.isEmpty()) {
      int index = qu.poll();
      if (index == s.length() - 1) {
        return true;
      }
      for (int i = Math.max(index + minJump, max); i < Math.min(index + maxJump + 1, s.length()); i++) {
        if (s.charAt(i) == '0') {
          qu.add(i);
        }
      }
      max = Math.max(max, index + maxJump);
    }

    return false;
  }
}
