class MedianOfSortedArray {

  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int i = 0;
    int j = 0;
    int k = 0;
    double ans;
    int[] arr = new int[nums1.length + nums2.length];
    while (i < nums1.length && j < nums2.length) {
      if (nums1[i] <= nums2[j]) {
        arr[k++] = nums1[i];
        i++;
      } else {
        arr[k++] = nums2[j];
        j++;
      }
    }
    while (i < nums1.length) {
      arr[k++] = nums1[i++];
    }
    while (j < nums2.length) {
      arr[k++] = nums2[j++];
    }

    if (arr.length % 2 == 0) {
      int index = arr.length / 2;
      ans = (arr[index - 1] + arr[index]) / 2.0;
    } else {
      int index = arr.length / 2;
      ans = (double) (arr[index]);
    }
    return ans;
  }
}