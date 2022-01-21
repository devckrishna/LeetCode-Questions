public class GasStation {
  public int canCompleteCircuit(int[] gas, int[] cost) {
    int count = 0;
    for (int i = 0; i < gas.length; i++) {
      count += gas[i] - cost[i];
    }
    if (count < 0) {
      return -1;
    }
    int index = 0;
    count = 0;
    for (int i = 0; i < gas.length; i++) {
      count += gas[i] - cost[i];
      if (count < 0) {
        count = 0;
        index = i + 1;
      }
    }
    return index;
  }
}
