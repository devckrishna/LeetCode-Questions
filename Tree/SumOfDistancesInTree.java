import java.util.*;

public class SumOfDistancesInTree {
  public int[] sumOfDistancesInTree(int N, int[][] edges) {
    Queue<int[]> qu=new LinkedList<>();
    qu.add(edges[0]);
    int level=1;
    int ans=0;
    while(!qu.isEmpty()){
      int[] temp=qu.remove();
      int currCount=0;
      if(temp[0]!=0){
        currCount++;
        qu.add
      }
      if(temp[1]!=0){
        currCount++;
      }
      ans+=currCount*level;
      level++;
    }
  }
}
