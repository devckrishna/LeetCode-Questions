public class CountVovelSorteedStrings {
  public int countVowelStrings(int n) {
    int[] arr = new int[5];
    arr[0] = 1;
    for (int i = 0; i <= n; i++) {
      for (int j = 1; j < 5; j++) {
        arr[j] += arr[j - 1];
      }
    }
    return arr[4];
  }
}