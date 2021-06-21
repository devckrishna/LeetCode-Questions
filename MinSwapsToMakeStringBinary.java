public class MinSwapsToMakeStringBinary {
  public int minSwaps(String s) {
    int ones = 0;
    int zeros = 0;
    for (char ch : s.toCharArray()) {
      if (ch == '1') {
        ones++;
      } else {
        zeros++;
      }
    }
    if (Math.abs(ones - zeros) > 1) {
      return -1;
    }
    int first = solve(s, '1');
    int second = solve(s, '0');
    if (ones > zeros) {
      return first;
    } else if (zeros > ones) {
      return second;
    }
    return Math.min(first, second);
  }

  public int solve(String s, char ch) {
    int swaps = 0;
    for (char c : s.toCharArray()) {
      if (ch != c) {
        swaps++;
      }
      ch ^= 1;
    }

    return swaps / 2;
  }
}
