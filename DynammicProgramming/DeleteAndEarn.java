public class DeleteAndEarn {
  public int deleteAndEarn(int[] nums) {
    int[] numbers = new int[10001];
    for (int num : nums) {
      numbers[num] += num;
    }
    int prev1 = 0;
    int prev2 = 0;
    for (int num : numbers) {
      int temp = prev1;
      prev1 = Math.max(prev2 + num, prev1);
      prev2 = temp;
    }
    return prev1;
  }
}