public class FindStudentThatWillReplaceChalk {
  public int chalkReplacer(int[] chalk, int k) {
    long sum = 0;
    for (int i = 0; i < chalk.length; i++) {
      sum += chalk[i];
      if (sum >= k) {
        return i;
      }
    }
    k = k % (int) sum;
    for (int i = 0; i < chalk.length; i++) {
      if (k - chalk[i] < 0) {
        return i;
      }
      k = k - chalk[i];
    }
    return -1;
  }

  public static void main(String[] args) {
    System.out.println(25 % 626593775);
  }
}
