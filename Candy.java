import java.util.Arrays;

public class Candy {
  public int candy(int[] ratings) {
    int[] arr = new int[ratings.length];
    Arrays.fill(arr, 1);
    for (int i = 1; i < arr.length; i++) {
      if (ratings[i] > ratings[i - 1]) {
        arr[i] = arr[i - 1] + 1;
      }
    }
    int ans = arr[arr.length - 1];
    for (int i = arr.length - 2; i >= 0; i--) {
      if (ratings[i] > ratings[i + 1]) {
        arr[i] = Math.max(arr[i], arr[i + 1] + 1);
      }
      ans += arr[i];
    }
    return ans;
  }
}