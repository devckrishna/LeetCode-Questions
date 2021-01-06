class SortColors {
  public static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public void sortColors(int[] nums) {
    int i = 0;
    int j = 0;
    int k = nums.length - 1;
    while (j <= k) {
      switch (nums[j]) {
        case 0:
          swap(nums, i, j);
          i++;
          j++;
          break;
        case 1:
          j++;
          break;
        case 2:
          swap(nums, j, k);
          k--;
        default:
          break;
      }
    }
  }
}