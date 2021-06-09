import java.util.*;

class Sum3 {
  public List<List<Integer>> threeSum(int[] arr) {
    Arrays.sort(arr);
    Set<List<Integer>> map = new HashSet<>();
    int k = arr.length - 1;

    for (int i = 0; i < arr.length - 2; i++) {
      int j = i + 1;
      k = arr.length - 1;

      while (j < k) {
        int sum = arr[j] + arr[k];

        if (sum == -arr[i]) {
          map.add(Arrays.asList(arr[i], arr[j], arr[k]));
          j++;
          k--;
        }

        else if (sum < -arr[i])
          j++;

        else if (sum > -arr[i])
          k--;

      }
    }
    return new ArrayList<>(map);
  }
}