public class MaxPopulationYear {
  public int maximumPopulation(int[][] logs) {
    int[] map = new int[2051];
    int ans = 0;
    for (int[] arr : logs) {
      map[arr[0]]++;
      map[arr[1]]--;
    }
    for (int i = 1950; i < 2051; i++) {
      map[i] += map[i - 1];
      ans = map[i] > map[ans] ? i : ans;
    }
    return ans;
  }
}
