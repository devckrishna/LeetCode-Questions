import java.util.Arrays;

public class BestTeamWithNoConflicts {
  public class Pair implements Comparable<Pair> {
    int score;
    int age;

    public Pair(int score, int age) {
      this.score = score;
      this.age = age;
    }

    @Override
    public int compareTo(Pair o) {
      if (this.age == o.age) {
        return this.score - o.score;
      }
      return this.age - o.age;
    }
  }

  public int bestTeamScore(int[] scores, int[] ages) {
    Pair[] arr = new Pair[ages.length];
    for (int i = 0; i < ages.length; i++) {
      arr[i] = new Pair(scores[i], ages[i]);
    }
    Arrays.sort(arr);
    int ans = 0;
    int[] dp = new int[arr.length];
    for (int i = 0; i < dp.length; i++) {
      dp[i] = arr[i].score;
      for (int j = 0; j < i; j++) {
        if (arr[j].score <= arr[i].score) {
          dp[i] = Math.max(dp[i], dp[j] + arr[i].score);
        }
      }
      ans = Math.max(dp[i], ans);
    }
    return ans;
  }
}
