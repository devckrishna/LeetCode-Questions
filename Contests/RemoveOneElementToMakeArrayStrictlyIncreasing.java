
public class RemoveOneElementToMakeArrayStrictlyIncreasing {
  public boolean canBeIncreasing(int[] arr) {
    int count = 0;
    int index = -1;
    for (int i = 1; i < arr.length; i++) {
      if (arr[i - 1] >= arr[i]) {
        count++;
        index = i;
      }
    }

    if (count > 1)
      return false;

    if (count == 0)
      return true;

    if (index == arr.length - 1 || index == 1)
      return true;

    if (arr[index - 1] < arr[index + 1])
      return true;

    if (arr[index - 2] < arr[index])
      return true;

    return false;
  }
}
