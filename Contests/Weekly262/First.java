import java.util.*;

public class First {
  public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
    Set<Integer> ans = new HashSet<>();
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums1) {
      map.put(num, 1);
    }
    for (int num : nums2) {
      if (map.containsKey(num)) {
        ans.add(num);
      }
    }
    for (int num : nums2) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }
    for (int num : nums3) {
      if (map.containsKey(num)) {
        ans.add(num);
      }
    }
    return new ArrayList<>(ans);
  }
}