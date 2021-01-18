class MoveZeros {
  public void moveZeroes(int[] nums) {
    int i = 0;
    int j = 0;
    while (i < nums.length && j < nums.length) {
      if (nums[i] == 0) {
        while (j < nums.length - 1 && nums[j] == 0) {
          j++;
        }
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;

      }
      i++;
      j++;
    }
  }
}