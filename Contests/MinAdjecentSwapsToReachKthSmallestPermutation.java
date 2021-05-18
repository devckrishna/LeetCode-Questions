import java.util.Arrays;

public class MinAdjecentSwapsToReachKthSmallestPermutation {
  public int getMinSwaps(String num, int k) {
    int n = num.length();

    int[] number = new int[n];
    for (int i = 0; i < n; i++) {
      int digit = num.charAt(i) - '0';
      number[i] = digit;
    }

    int[] kthSmallestNumber = getKthSmallestNumber(number.clone(), k);

    return getMinSwaps(number, kthSmallestNumber);
  }

  private int[] getKthSmallestNumber(int[] nums, int k) {
    while (k-- > 0) {
      computeNextPermutation(nums);
    }
    return nums;
  }

  private void computeNextPermutation(int[] nums) {
    int n = nums.length;
    int i = n - 2;

    while (i >= 0 && nums[i] >= nums[i + 1]) {
      i--;
    }

    if (i >= 0) {
      int j = n - 1;
      while (j > i && nums[j] <= nums[i]) {
        j--;
      }
      swap(nums, i, j);
    }

    Arrays.sort(nums, i + 1, n);
  }

  private void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  private int getMinSwaps(int[] number, int[] kthSmallestNumber) {
    int swapCount = 0;
    int n = number.length;

    for (int i = 0; i < n; i++) {
      if (number[i] == kthSmallestNumber[i])
        continue;

      int j = i + 1;
      while (j < n && number[i] != kthSmallestNumber[j]) {
        j++;
      }

      while (j > i) {
        swap(kthSmallestNumber, j - 1, j);
        swapCount++;
        j--;
      }

    }

    return swapCount;
  }

}
