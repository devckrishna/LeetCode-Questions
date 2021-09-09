public class Second {
  public int equalSubstring(String s, String t, int maxCost) {
    int[] arr = new int[s.length()];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = Math.abs(s.charAt(i) - t.charAt(i));
    }
    int maxLen = 0;
    int sum = 0;
    int currLen = 0;
    for (int i = 0; i < arr.length; i++) {
      if ((sum + arr[i]) <= maxCost) {
        sum += arr[i];
        currLen++;
      } else if (sum != 0) {
        sum = sum - arr[i - currLen] + arr[i];
      }
      maxLen = Math.max(maxLen, currLen);
    }
    return maxLen;
  }
}
