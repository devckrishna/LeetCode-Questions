// import java.util.*;

public class CarPooling {
  public boolean carPooling(int[][] trips, int capacity) {
    int[] arr = new int[1001];
    for (int[] trip : trips) {
      arr[trip[1]] += trip[0];
      arr[trip[2]] -= trip[0];
    }
    int currCapacity = 0;
    for (int i = 0; i < arr.length; i++) {
      currCapacity += arr[i];
      if (currCapacity > capacity) {
        return false;
      }
    }
    return true;
  }
  // public boolean carPooling(int[][] trips, int capacity) {
  // Map<Integer, Integer> m = new TreeMap<>();
  // for (int[] t : trips) {
  // m.put(t[1], m.getOrDefault(t[1], 0) + t[0]);
  // m.put(t[2], m.getOrDefault(t[2], 0) - t[0]);
  // }
  // for (int v : m.values()) {
  // capacity -= v;
  // if (capacity < 0) {
  // return false;
  // }
  // }
  // return true;
  // }
  // public class Pair implements Comparable<Pair> {
  // int start;
  // int isDeparted;
  // int cap;

  // public Pair(int start, int isDeparted, int cap) {
  // this.start = start;
  // this.isDeparted = isDeparted;
  // this.cap = cap;
  // }

  // @Override
  // public int compareTo(Pair o) {
  // if (this.start == o.start) {
  // return this.isDeparted - o.isDeparted;
  // }

  // return this.start - o.start;
  // }
  // }

  // public boolean carPooling(int[][] trips, int capacity) {
  // List<Pair> arr = new ArrayList<>();
  // for (int[] trip : trips) {
  // arr.add(new Pair(trip[1], 1, trip[0]));
  // arr.add(new Pair(trip[2], 0, trip[0]));
  // }

  // Collections.sort(arr);
  // int currCapacity = 0;
  // for (Pair curr : arr) {
  // if (curr.isDeparted == 0) {
  // currCapacity -= curr.cap;
  // } else {
  // currCapacity += curr.cap;
  // }
  // if (currCapacity > capacity) {
  // return false;
  // }
  // }

  // return true;
  // }

}