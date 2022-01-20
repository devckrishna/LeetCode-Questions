public class First {
  public int finalValueAfterOperations(String[] operations) {
    int ans = 0;
    for (String op : operations) {
      if (op.equals("++X")) {
        ans++;
      } else if (op.equals("X++")) {
        ++ans;
      } else if (op.equals("--X")) {
        --ans;
      } else {
        ans--;
      }
    }
    return ans;
  }
}