public class Second {
  public int minimumBuckets(String street) {
    int ans = 0;
    StringBuilder sb = new StringBuilder(street);
    for (int i = 0; i < sb.length() - 2; i++) {
      if (sb.substring(i, i + 3).equals("H.H")) {
        int index = i;
        while (index < i + 3) {
          sb.setCharAt(index, '*');
          index++;
        }
        ans++;
      }
    }

    for (int i = 0; i < sb.length() - 1; i++) {
      if (sb.substring(i, i + 2).equals("H.")) {
        int index = i;
        while (index < i + 2) {
          sb.setCharAt(index, '*');
          index++;
        }
        ans++;
      }
    }
    for (int i = 0; i < sb.length() - 1; i++) {
      if (sb.substring(i, i + 2).equals(".H")) {
        int index = i;
        while (index < i + 2) {
          sb.setCharAt(index, '*');
          index++;
        }
        ans++;
      }
    }

    if (sb.toString().contains("H")) {
      return -1;
    } else {
      return ans;
    }
  }
}
