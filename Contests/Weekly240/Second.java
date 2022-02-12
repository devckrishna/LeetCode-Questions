public class Second {
  public int maxDistance(int[] nums1, int[] nums2) {
    int ans = 0;
    for (int i = 0; i < nums1.length; i++) {
      int start = i;
      int end = nums2.length - 1;
      while (start <= end) {
        int mid = (start + end) / 2;
        if (nums2[mid] >= nums1[i]) {
          ans = Math.max(ans, mid - i);
          start = mid + 1;
        } else {
          end = mid - 1;
        }
      }
    }
    return ans;
  }
}
