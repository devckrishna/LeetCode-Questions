public class MinimumDominoRotationsForEqualRow {
  public int minDominoRotations(int[] tops, int[] bottoms) {
    int[] first = new int[7];
    int[] second = new int[7];
    int[] same = new int[7];
    for (int i = 0; i < tops.length; i++) {
      first[tops[i]]++;
      second[bottoms[i]]++;
      if (tops[i] == bottoms[i]) {
        same[tops[i]]++;
      }
    }

    for (int i = 1; i <= 6; i++) {
      if (first[i] + second[i] - same[i] == tops.length) {
        return tops.length - Math.max(first[i], second[i]);
      }
    }
    return -1;
  }
}
