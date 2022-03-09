import java.util.*;

public class MovingAverage {
  List<Integer> arr;
  int size;

  public MovingAverage(int size) {
    arr = new ArrayList<>();
    arr.add(0);
    this.size = size;
  }

  public double next(int val) {
    if (arr.size() == 0) {
      arr.add(val);
    } else {
      arr.add(arr.get(arr.size() - 1) + val);
    }
    int numerator = arr.get(arr.size() - 1) - arr.get(Math.max(0, arr.size() - size - 1));
    double denominator = Math.min(arr.size() - 1, size) * 1.0;
    System.out.println(numerator + " " + denominator);
    return numerator / denominator;
  }
}
