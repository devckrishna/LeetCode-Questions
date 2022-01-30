import java.util.*;

public class Second {
  public List<Integer> maxScoreIndices(int[] nums) {
    List<Integer> ans = new ArrayList<>();
    int[] left = new int[nums.length + 1];
    int[] right = new int[nums.length + 1];
    left[0] = 0;
    right[right.length - 1] = 0;
    for (int i = 1; i < left.length; i++) {
      left[i] = left[i - 1];
      if (nums[i - 1] == 0) {
        left[i]++;
      }
    }

    for (int i = right.length - 2; i >= 0; i--) {
      right[i] = right[i + 1];
      if (nums[i] == 1) {
        right[i]++;
      }
    }
    int[] score = new int[nums.length + 1];
    int max = 0;
    for (int i = 0; i < score.length; i++) {
      score[i] = left[i] + right[i];
      max = Math.max(score[i], max);
    }
    for (int i = 0; i < score.length; i++) {
      if (score[i] == max) {
        ans.add(i);
      }
    }
    return ans;
  }
}
