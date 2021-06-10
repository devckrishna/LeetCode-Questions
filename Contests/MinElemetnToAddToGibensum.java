public class MinElemetnToAddToGibensum {
  public int minElements(int[] A, int limit, int goal) {
    long sum = 0, diff;
    for (int a : A)
      sum += a;
    diff = Math.abs(goal - sum);
    return (int) ((diff + limit - 1) / limit);
  }
}
