import java.util.*;

public class PartitionLabels {
  public List<Integer> partitionLabels(String s) {
    List<Integer> ans = new ArrayList<>();
    int[] last = new int[26];
    for (int i = 0; i < s.length(); i++) {
      last[s.charAt(i) - 'a'] = i;
    }

    int anchor = 0;
    int right = 0;
    for (int start = 0; start < s.length(); start++) {
      right = Math.max(last[s.charAt(start) - 'a'], right);
      if (start == right) {
        ans.add(right - anchor + 1);
        anchor = start + 1;
      }
    }
    return ans;
  }
}