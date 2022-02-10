public class CountNumberOfTeams {
  public int numTeams(int[] rating) {
    int ans = 0;
    for (int i = 1; i < rating.length - 1; i++) {
      int rightLess = 0;
      int rightMore = 0;
      for (int j = i + 1; j < rating.length; j++) {
        if (rating[j] > rating[i]) {
          rightMore++;
        } else if (rating[j] < rating[i]) {
          rightLess++;
        }
      }
      int leftMore = 0;
      int leftLess = 0;
      for (int j = 0; j < i; j++) {
        if (rating[j] > rating[i]) {
          leftMore++;
        } else if (rating[j] < rating[i]) {
          leftLess++;
        }
      }
      ans += (leftMore * rightLess) + (leftLess * rightMore);
    }
    return ans;
  }
}
