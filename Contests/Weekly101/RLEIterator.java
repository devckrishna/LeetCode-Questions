public class RLEIterator {
  String[] arr;
  int indexI = 0;

  public RLEIterator(int[] encoding) {
    arr = new String[encoding.length / 2];
    int index = 0;
    for (int i = 1; i < encoding.length; i += 2) {
      String curr = encoding[i] + "," + encoding[i - 1];
      arr[index++] = curr;
    }
  }

  public int next(int n) {
    int ans = -1;
    while (indexI < arr.length && n > 0) {
      String[] temp = arr[indexI].split(",");
      int num = Integer.parseInt(temp[0]);
      int count = Integer.parseInt(temp[1]);
      int remove = Math.min(n, count);
      n -= remove;
      ans = num;
      String newTemp = num + "," + (count - remove);
      arr[indexI] = newTemp;
      if (count - remove == 0) {
        indexI++;
      }
    }
    if (n > 0) {
      return -1;
    } else {
      return ans;
    }
  }
}