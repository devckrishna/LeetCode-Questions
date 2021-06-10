public class MinOperationsToMoveAllTheBalls {
  public int[] minOperations(String boxes) {
    int[] ans = new int[boxes.length()];
    int[] left = new int[boxes.length()];
    int[] right = new int[boxes.length()];

    int count = boxes.charAt(0) - '0';

    for (int i = 1; i < left.length; i++) {
      left[i] = left[i - 1] + count;
      count += boxes.charAt(i) - '0';
    }

    count = boxes.charAt(boxes.length() - 1) - '0';
    for (int i = right.length - 2; i >= 0; i--) {
      right[i] = right[i + 1] + count;
      count += boxes.charAt(i) - '0';
    }

    for (int i = 0; i < ans.length; i++) {
      ans[i] = left[i] + right[i];
    }
    return ans;
  }
}
