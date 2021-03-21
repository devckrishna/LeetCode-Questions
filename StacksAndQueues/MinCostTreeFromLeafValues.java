package StacksAndQueues;

class MinCostTreeFromLeafValues {
  public int mctFromLeafValues(int[] arr) {
    int[] sum = new int[1];
    solve(arr, 0, arr.length - 1, sum);
    return sum[0];
  }

  public static int solve(int[] arr, int i, int j, int[] sum) {
    if (i < 0 || j < 0 || i >= arr.length || j >= arr.length || i > j) {
      return 0;
    }
    if (i == j - 1) {
      sum[0] += arr[i] * arr[j];
      return Math.max(arr[i], arr[j]);
    }
    int maxIndex = i;
    for (int k = i; k <= j; k++) {
      if (arr[k] >= arr[maxIndex]) {
        maxIndex = k;
      }
    }

    int max1 = solve(arr, i, maxIndex - 1, sum);
    int max2 = solve(arr, maxIndex + 1, j, sum);

    if (max1 > 0)
      sum[0] += arr[maxIndex] * max1;
    if (max2 > 0)
      sum[0] += arr[maxIndex] * max2;

    int max = Math.max(max1, max2);

    return Math.max(arr[maxIndex], max);

  }

}