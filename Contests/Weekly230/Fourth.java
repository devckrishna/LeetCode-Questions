import java.util.*;

public class Fourth {
  public int minOperations(int[] nums1, int[] nums2) {

    int sum1 = 0, sum2 = 0, ans = 0;
    for (int num : nums1)
      sum1 += num;
    for (int num : nums2)
      sum2 += num;

    if (sum1 == sum2)
      return 0;

    if (sum1 > sum2) {
      int[] temp = nums1;
      nums1 = nums2;
      nums2 = temp;

      int temp2 = sum1;
      sum1 = sum2;
      sum2 = temp2;
    }

    if (6 * nums1.length < nums2.length)
      return -1;

    PriorityQueue<Integer> heap1 = new PriorityQueue<Integer>();
    PriorityQueue<Integer> heap2 = new PriorityQueue<Integer>(Collections.reverseOrder());

    for (int num : nums1)
      heap1.add(num);

    for (int num : nums2)
      heap2.add(num);

    while (sum1 < sum2) {
      int increment = 6 - heap1.peek();
      int decrement = (heap2.size() != 0) ? heap2.peek() - 1 : 0;

      if (increment > decrement) {
        sum1 += increment;
        heap1.poll();
      } else {
        sum2 -= decrement;
        heap2.poll();
      }

      ans++;
    }

    return ans;
  }
}
