public class some {
  public int solve(int n, int index, int i, int j, char arr[]) {
    if (i < 0 || j < 0 || i >= n || j >= n || index == arr.length)
      return 0;
    if (arr[index] == 'R') {
      if (j + 1 >= n) {
        return 0;
      }
      return 1 + solve(n, index + 1, i, j + 1, arr);
    } else if (arr[index] == 'L') {
      if (j - 1 < 0) {
        return 0;
      }
      return 1 + solve(n, index + 1, i, j - 1, arr);
    } else if (arr[index] == 'U') {
      if (i - 1 < 0) {
        return 0;
      }
      return 1 + solve(n, index + 1, i - 1, j, arr);
    } else if (arr[index] == 'D') {
      if (i + 1 >= n) {
        return 0;
      }
      return 1 + solve(n, index + 1, i + 1, j, arr);
    } else
      return 0;
  }

  public int[] executeInstructions(int n, int[] pos, String s) {
    int len = s.length();
    int ans[] = new int[len];
    for (int i = 0; i < len; i++)
      ans[i] = solve(n, 0, pos[0], pos[1], s.substring(i, len).toCharArray());
    return ans;
  }
}
