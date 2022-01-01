public class ExecutaionOfAllSuffixStrings {
  public int solve(int n, int index, int pos[], char arr[]) {
    if (index == arr.length)
      return 0;
    if (arr[index] == 'R' && pos[1] + 1 < n)
      return 1 + solve(n, index + 1, new int[] { pos[0], pos[1] + 1 }, arr);
    else if (arr[index] == 'L' && pos[1] - 1 >= 0)
      return 1 + solve(n, index + 1, new int[] { pos[0], pos[1] - 1 }, arr);
    else if (arr[index] == 'U' && pos[0] - 1 >= 0)
      return 1 + solve(n, index + 1, new int[] { pos[0] - 1, pos[1] }, arr);
    else if (arr[index] == 'D' && pos[0] + 1 < n)
      return 1 + solve(n, index + 1, new int[] { pos[0] + 1, pos[1] }, arr);
    else
      return 0;
  }

  public int[] executeInstructions(int n, int[] pos, String s) {
    int i, len = s.length();
    int ans[] = new int[len];
    for (i = 0; i < len; i++)
      ans[i] = solve(n, 0, pos, s.substring(i, len).toCharArray());
    return ans;
  }
}
