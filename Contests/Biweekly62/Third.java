public class Third {
  public int maxConsecutiveAnswers(String answerKey, int k) {
    int[] arr = new int[answerKey.length()];
    for (int i = 0; i < answerKey.length(); i++) {
      arr[i] = answerKey.charAt(i) == 'T' ? 1 : 0;
    }
    int first = solve(arr, arr.length, k);
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == 0) {
        arr[i] = 1;
      } else {
        arr[i] = 0;
      }
    }
    int second = solve(arr, arr.length, k);
    return Math.max(first, second);
  }

  public int solve(int a[], int n, int k) {
    int left = 0;
    int l = 0;
    int ans = 0;

    for (int i = 0; i < n; i++) {
      if (a[i] == 0)
        left++;
      while (left > k) {
        if (a[l] == 0)
          left--;
        l++;
      }

      ans = Math.max(ans, i - l + 1);
    }

    return ans;
  }
}
