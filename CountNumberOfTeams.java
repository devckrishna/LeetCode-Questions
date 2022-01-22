public class CountNumberOfTeams {
  public int numTeams(int[] rating) {
    int ans = 0;
    for (int i = 1; i < rating.length - 1; i++) {
      int leftSmall = 0;
      int leftLarge = 0;
      int rightSmall = 0;
      int rightLarge = 0;
      for (int j = i - 1; j >= 0; j--) {
        if (rating[j] > rating[i]) {
          leftLarge++;
        } else if (rating[j] < rating[i]) {
          leftSmall++;
        }
      }

      for (int j = i + 1; j < rating.length; j++) {
        if (rating[j] > rating[i]) {
          rightLarge++;
        } else if (rating[j] < rating[i]) {
          rightSmall++;
        }
      }

      ans += leftLarge * rightSmall + leftSmall * rightLarge;
    }
    return ans;
  }
}