import java.util.*;

public class NestedListWeightSum {
  public interface NestedInteger {
    // public NestedInteger()

    // public NestedInteger(int value);

    public boolean isInteger();

    public Integer getInteger();

    public void setInteger(int value);

    public void add(NestedInteger ni);

    public List<NestedInteger> getList();
  }

  public int dfs(List<NestedInteger> arr, int depth) {
    int sum = 0;
    for (NestedInteger curr : arr) {
      if (curr.isInteger()) {
        sum += curr.getInteger() * depth;
      } else {
        sum += dfs(curr.getList(), depth + 1);
      }
    }
    return sum;
  }

  public int depthSum(List<NestedInteger> nestedList) {
    return dfs(nestedList, 1);
  }
}
