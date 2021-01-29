class MaxPointsYouCouldObtainFromCard {
  public int maxScore(int[] cardPoints, int k) {
    int windows = 0;
    int total = 0;
    for (int i = 0; i < cardPoints.length; i++) {
      total += cardPoints[i];
      if (i < cardPoints.length - k) {
        windows += cardPoints[i];
      }
    }

    int max = total - windows;

    for (int i = cardPoints.length - k; i < cardPoints.length; i++) {
      windows += cardPoints[i] - cardPoints[i - cardPoints.length + k];
      max = Math.max(max, total - windows);
    }
    return max;

  }
}