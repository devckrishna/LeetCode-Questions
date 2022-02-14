import java.util.*;

public class First {
  public int minimumSum(int num) {
    String curr = num + "";
    int[] arr = new int[4];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = curr.charAt(i) - '0';
    }
    Arrays.sort(arr);
    return (arr[0] * 10 + arr[2]) + (arr[1] * 10 + arr[3]);
  }
}