import java.util.*;

public class KthSumMatrixWithSortedSum {
  public int kthSmallest(int[][] mat, int k) {
    int col = Math.min(mat[0].length, k);

    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    pq.add(0);
    for (int[] row : mat) {
      PriorityQueue<Integer> nextPq = new PriorityQueue<>(Collections.reverseOrder());
      for (int i : pq) {
        for (int c = 0; c < col; c++) {
          nextPq.add(i + row[c]);
          if (nextPq.size() > k) {
            nextPq.poll();
          }
        }
      }
      pq = nextPq;
    }
    return pq.poll();
  }
}
