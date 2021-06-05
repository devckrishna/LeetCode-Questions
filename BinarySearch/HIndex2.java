public class HIndex2 {
  public int hIndex(int[] citations) {
    int len = citations.length;
    int start = 0, end = len - 1;
    while (start <= end) {
      int med = (end + start) / 2;
      if (citations[med] == len - med) {
        return len - med;
      } else if (citations[med] < len - med) {
        start = med + 1;
      } else {
        end = med - 1;
      }
    }
    return len - start;
  }
}
