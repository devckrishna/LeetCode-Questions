public class Second {
  public int wateringPlants(int[] plants, int capacity) {
    int curr = capacity;
    int ans = 0;
    for (int i = 0; i < plants.length; i++) {
      ans++;
      if (capacity < plants[i]) {
        ans += 2 * i;
        capacity = curr - plants[i];
      } else {
        capacity -= plants[i];
      }
    }

    return ans;
  }
}
