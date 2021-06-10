import java.util.Arrays;

public class CountLIS {
  public int findNumberOfLIS(int[] nums) {

    int n = nums.length;
    int[] lenOfSeq = new int[n];
    Arrays.fill(lenOfSeq, 1);

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < i; j++) {
        if (nums[i] > nums[j]) {
          lenOfSeq[i] = Math.max(lenOfSeq[i], lenOfSeq[j] + 1);
        }
      }
    }

    int maxSeqLen = 1;
    for (int i = 0; i < n; i++) {
      maxSeqLen = Math.max(lenOfSeq[i], maxSeqLen);
    }

    int[] noOfSeq = new int[n];
    for (int i = 0; i < n; i++) {
      if (lenOfSeq[i] == 1) {
        noOfSeq[i] = 1;
      } else {
        for (int j = 0; j < i; j++) {
          if (lenOfSeq[i] == lenOfSeq[j] + 1 && nums[i] > nums[j]) {
            noOfSeq[i] = noOfSeq[i] + noOfSeq[j];
          }
        }
      }
    }

    int noOfMaxSeq = 0;
    for (int i = 0; i < n; i++) {
      if (maxSeqLen == lenOfSeq[i]) {
        noOfMaxSeq = noOfMaxSeq + noOfSeq[i];
      }
    }
    return noOfMaxSeq;
  }
}
