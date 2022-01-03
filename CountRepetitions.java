public class CountRepetitions {
  public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
    int count1 = 0;
    int count2 = 0;
    int i = 0;
    int j = 0;
    while (count1 < n1) {
      if (s1.charAt(i) == s2.charAt(j)) {
        j++;
        if (j == s2.length()) {
          j = 0;
          count2++;
        }
      }
      i++;
      if (i == s1.length()) {
        i = 0;
        count1++;
      }
    }
    return count2 / n2;
  }
}
