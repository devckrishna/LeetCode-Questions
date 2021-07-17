import java.util.Arrays;

public class MinTimeToFinishAllJobs {
  int ans = Integer.MAX_VALUE;

  public int minimumTimeRequired(int[] jobs, int k) {
    Arrays.sort(jobs);
    solve(jobs, jobs.length - 1, k, new int[k]);
    return ans;
  }

  public void solve(int[] jobs, int index, int k, int[] arr) {
    if (index < 0) {
      ans = Math.min(ans, Arrays.stream(arr).max().getAsInt());
      return;
    }
    if (Arrays.stream(arr).max().getAsInt() >= ans) {
      return;
    }
    for (int i = 0; i < arr.length; i++) {
      if (i > 0 && arr[i] == arr[i - 1]) {
        continue;
      }
      arr[i] += jobs[index];
      solve(jobs, index - 1, k, arr);
      arr[i] -= jobs[index];
    }
  }
}
