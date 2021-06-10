import java.util.*;

class PartitionLabels {
  public List<Integer> partitionLabels(String S) {
    int[] last = new int[26];
    for (int i = 0; i < S.length(); i++) {
      last[S.charAt(i) - 'a'] = i;
    }
    List<Integer> ans = new ArrayList<>();
    int j = 0;
    int anchor = 0;
    for (int i = 0; i < S.length(); i++) {
      j = Math.max(j, last[S.charAt(i) - 'a']);
      if (i == j) {
        ans.add(i - anchor + 1);
        anchor = i + 1;
      }
    }
    return ans;
  }
}