public class CanPlaceFlowers {
  public boolean canPlaceFlowers(int[] flowerBed, int n) {
    for (int i = 0; i < flowerBed.length; i++) {
      if (flowerBed[i] == 0 && (i == 0 || flowerBed[i - 1] == 0)
          && (i == flowerBed.length - 1 || flowerBed[i + 1] == 0)) {
        flowerBed[i] = 1;
        n--;
      }
    }
    return n <= 0;
  }
}
