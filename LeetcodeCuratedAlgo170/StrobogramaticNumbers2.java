import java.util.*;

public class StrobogramaticNumbers2 {
  int temp;

  public List<String> solve(int n) {
    List<String> ans = new ArrayList<>();
    if (n <= 0) {
      return ans;
    } else if (n == 1) {
      ans.add("0");
      ans.add("8");
      ans.add("1");
      return ans;
    } else if (n == 2) {
      ans.add("00");
      ans.add("11");
      ans.add("69");
      ans.add("96");
      ans.add("88");
      return ans;
    }
    List<String> recAns = solve(n - 2);
    for (String curr : recAns) {
      if (temp > n) {
        ans.add("0" + curr + "0");
      }
      ans.add("1" + curr + "1");
      ans.add("6" + curr + "9");
      ans.add("9" + curr + "6");
      ans.add("8" + curr + "8");
    }
    return ans;
  }

  public List<String> findStrobogrammatic(int n) {
    temp = n;
    if (n == 2) {
      List<String> ans = new ArrayList<>();
      ans.add("11");
      ans.add("69");
      ans.add("96");
      ans.add("88");
      return ans;
    }
    List<String> ans = solve(n);
    return ans;
  }
}
