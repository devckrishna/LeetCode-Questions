import java.util.Arrays;

public class BoatsToSavePeople {
  public int numRescueBoats(int[] people, int limit) {
    int ans = 0;
    Arrays.sort(people);
    int i = 0;
    int j = people.length - 1;
    while (i <= j) {
      if (i != j && people[i] + people[j] <= limit) {
        i++;
      }
      j--;
      ans++;
    }
    return ans;
  }
}
