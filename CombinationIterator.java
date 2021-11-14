import java.util.*;

class CombinationIterator {
  List<String> arr;
  int index;
  int len;

  public CombinationIterator(String characters, int combinationLength) {
    this.arr = new ArrayList<>();
    this.len = combinationLength;
    this.index = 0;
    this.solve(characters, 0, "");
  }

  public void solve(String s, int i, String ans) {
    if (ans.length() == len) {
      arr.add(ans);
      return;
    }
    if (i >= s.length()) {
      return;
    }
    for (int j = i; j < s.length(); j++) {
      solve(s, j + 1, ans + s.charAt(j));
    }
  }

  public String next() {
    return arr.get(this.index++);
  }

  public boolean hasNext() {
    return this.index < arr.size();
  }
}