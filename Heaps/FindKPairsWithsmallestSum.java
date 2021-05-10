import java.util.*;

public class FindKPairsWithsmallestSum {
  public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
    List<List<Integer>> ans = new ArrayList<>();
    PriorityQueue<List<Integer>> pq = new PriorityQueue<>((a, b) -> (a.get(0) + a.get(1)) - (b.get(0) + b.get(1)));
    for (int i = 0; i < nums1.length; i++) {
      for (int j = 0; j < nums2.length; j++) {
        List<Integer> arr = new ArrayList<>();
        arr.add(nums1[i]);
        arr.add(nums2[j]);
        pq.add(arr);
      }
    }

    for (int i = 0; i < k && pq.size() > 0; i++) {
      ans.add(pq.poll());
    }

    return ans;
  }
}
