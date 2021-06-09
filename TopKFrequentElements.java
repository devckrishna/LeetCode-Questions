import java.util.*;

class TopKFrequentElements {
  public int[] topKFrequent(int[] nums, int k) {
    HashMap<Integer, Integer> map = new HashMap<>();
    Queue<Integer> heap = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));
    for (int i = 0; i < nums.length; i++) {
      if (map.containsKey(nums[i])) {
        map.replace(nums[i], map.get(nums[i]) + 1);
      } else {
        map.put(nums[i], 1);
      }
    }

    for (int num : map.keySet()) {
      heap.add(num);
      if (heap.size() > k) {
        heap.poll();
      }
    }

    int[] ans = new int[k];
    for (int i = k - 1; i >= 0; i--) {
      ans[i] = heap.poll();
    }
    return ans;
  }
}