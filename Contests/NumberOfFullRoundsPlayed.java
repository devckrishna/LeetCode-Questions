public class NumberOfFullRoundsPlayed {
  public int numberOfRounds(String startTime, String finishTime) {
    String[] start = startTime.split(":");
    String[] finish = finishTime.split(":");

    int sIndex = Integer.parseInt(start[1]);
    int fIndex = Integer.parseInt(finish[1]);
    while (sIndex % 15 != 0) {
      sIndex++;
    }
    while (fIndex % 15 != 0) {
      fIndex--;
    }
    int one = (Integer.parseInt(start[0]) * 60) + sIndex;
    int two = (Integer.parseInt(finish[0]) * 60) + fIndex;
    if (two < one) {
      two += 24 * 60;
    }
    return (two - one) / 15;
  }
}
