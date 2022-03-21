import java.util.*;

public class PartitionLabels {
  public List<Integer> partitionLabels(String s) {
    int[] arr = new int[26];
    for (int i = 0; i < s.length(); i++) {
      arr[s.charAt(i) - 'a'] = i;
    }
    int start = 0;
    int end = 0;
    List<Integer> ans = new ArrayList<>();

    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      end = Math.max(end, arr[ch - 'a']);
      if (i == end) {
        ans.add(end - start + 1);
        start = end + 1;
      }
    }

    return ans;
  }
}
