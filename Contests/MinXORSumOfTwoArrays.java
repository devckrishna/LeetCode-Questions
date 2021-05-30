import java.util.*;

public class MinXORSumOfTwoArrays {
  public static int func(int[] nums1, int[] nums2, int i, int n, boolean[] arr, HashMap<String, Integer> map) {
    if (i == n)
      return 0;
    String curr = Integer.toString(i);
    for (int k = 0; k < n; k++)
      if (arr[k])
        curr += ";" + Integer.toString(k);
    if (map.containsKey(curr))
      return map.get(curr);
    int min = Integer.MAX_VALUE;
    for (int j = 0; j < n; j++) {
      if (!arr[j]) {
        arr[j] = true;
        min = Math.min(min, (nums1[i] ^ nums2[j]) + func(nums1, nums2, i + 1, n, arr, map));
        arr[j] = false;
      }
    }
    map.put(curr, min);
    return min;
  }

  public int minimumXORSum(int[] nums1, int[] nums2) {
    int n = nums1.length;
    HashMap<String, Integer> map = new HashMap<>();
    boolean[] arr = new boolean[n];
    return func(nums1, nums2, 0, n, arr, map);
  }
}
