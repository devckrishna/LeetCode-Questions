class FindDuplicateNumber {
  public int findDuplicate(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
      int val = Math.abs(nums[i]);
      int currEl = nums[val];
      if (currEl < 0) {
        return Math.abs(val);
      } else {
        nums[val] = -nums[val];
      }
    }
    return -1;
  }
}