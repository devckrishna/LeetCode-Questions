public class KEmptySlots {
  public int kEmptySlots(int[] bulbs, int k) {
    int[] arr = new int[bulbs.length];
    for (int i = 0; i < arr.length; i++) {
      arr[bulbs[i] - 1] = i + 1;
    }
    int left = 0;
    int right = k + 1;
    int ans = Integer.MAX_VALUE;
    for (int i = 0; right < bulbs.length; i++) {
      if (arr[i] < arr[left] || arr[i] <= arr[right]) {
        if (right == i) {
          ans = Math.min(ans, Math.max(arr[left], arr[right]));
        }
        left = i;
        right = i + k + 1;
      }
    }

    return ans == Integer.MAX_VALUE ? -1 : ans;
  }
}
