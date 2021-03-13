import java.util.HashMap;

public class TupleWithSameProduct {
  public int tupleSameProduct(int[] nums) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length - 1; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        int prod = nums[i] * nums[j];
        if (map.containsKey(prod)) {
          map.put(prod, map.get(prod) + 1);
        } else {
          map.put(prod, 1);
        }
      }
    }
    int count = 0;
    for (int prod : map.keySet()) {
      if (map.get(prod) > 1) {
        int n = map.get(prod);
        count += (n * (n - 1)) / 2;
      }
    }
    return count * 8;
  }
}
