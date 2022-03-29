import java.util.*;

public class Third {
  public int subarrayBitwiseORs(int[] arr) {
    Set<Integer> ans = new HashSet<>();
    Set<Integer> prev = new HashSet<>();

    for (int num : arr) {
      Set<Integer> curr = new HashSet<>();
      curr.add(num);
      for (int temp : prev)
        curr.add(num | temp);
      prev = curr;
      ans.addAll(curr);
    }

    return ans.size();
  }
}
