public class Second {
  public int[] minOperations(String boxes) {
    int n = boxes.length();
    int[] ans = new int[n];
    int[] left = new int[n];
    int[] right = new int[n];

    for (int i = 0; i < n; i++) {
      for (int j = n - 1; j > i; j--) {
        if (boxes.charAt(j) == '1') {
          left[i] += j - i;
        }
      }
    }

    for (int i = n - 1; i >= 0; i--) {
      for (int j = 0; j < i; j++) {
        if (boxes.charAt(j) == '1') {
          right[i] += i - j;
        }
      }
    }

    for (int i = 0; i < n; i++) {
      ans[i] += right[i] + left[i];
    }

    return ans;
  }
}
