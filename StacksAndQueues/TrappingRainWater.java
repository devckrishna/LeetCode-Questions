public class TrappingRainWater {
  public int trap(int[] arr) {

    int[] lMax = new int[arr.length];
    for (int i = 0; i < lMax.length; i++) {
      if (i == 0) {
        lMax[i] = arr[i];
      } else {
        lMax[i] = Math.max(arr[i], lMax[i - 1]);
      }
    }
    int[] rMax = new int[arr.length];

    for (int i = arr.length - 1; i >= 0; i--) {
      if (i == arr.length - 1) {
        rMax[i] = arr[i];
      } else {
        rMax[i] = Math.max(arr[i], rMax[i + 1]);
      }
    }

    int ans = 0;
    int waterAtI;
    for (int i = 0; i < arr.length; i++) {
      waterAtI = Math.min(lMax[i], rMax[i]);
      ans += waterAtI - arr[i];
    }

    return ans;
  }
}
