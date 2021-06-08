public class SatisfyEqualityOfEquations {
  int[] union = new int[26];

  public boolean equationsPossible(String[] equations) {
    for (int i = 0; i < 26; i++) {
      union[i] = i;
    }
    for (String s : equations) {
      if (s.charAt(1) == '=') {
        union[find(s.charAt(0) - 'a')] = find(s.charAt(3) - 'a');
      }
    }
    for (String s : equations) {
      if (s.charAt(1) == '!' && find(s.charAt(0) - 'a') == find(s.charAt(3) - 'a')) {
        return false;
      }
    }
    return true;
  }

  public int find(int x) {
    if (union[x] != x) {
      union[x] = find(union[x]);
    }
    return union[x];
  }
}
