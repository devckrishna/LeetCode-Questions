public class Second {
  public int minSwaps(int[] nums) {
    int window = 0;
    int ans = nums.length;
    for (int i : nums) {
      if (i == 1) {
        window++;
      }
    }
    if (window == 0) {
      return 0;
    }
    int[] arr = new int[nums.length * 2];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = nums[i % nums.length];
    }
    int i = 0;
    int j = 0;
    int count = 0;
    while (j < arr.length) {
      if (arr[j] == 1) {
        count++;
      }
      if (j - i + 1 == window) {
        ans = Math.min(ans, window - count);
        if (arr[i] == 1) {
          count--;
        }
        i++;
      }
      j++;
    }
    return ans;
  }
}
