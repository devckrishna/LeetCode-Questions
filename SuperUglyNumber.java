import java.util.PriorityQueue;

public class SuperUglyNumber {
  public class Pair implements Comparable<Pair> {
    int prime;
    int pointer;
    int value;

    public Pair(int prime, int pointer, int value) {
      this.prime = prime;
      this.pointer = pointer;
      this.value = value;
    }

    @Override
    public int compareTo(Pair o) {
      return this.value - o.value;
    }

  }

  public int nthSuperUglyNumber(int n, int[] primes) {
    int[] dp = new int[n + 1];
    PriorityQueue<Pair> pq = new PriorityQueue<>();
    for (int i = 0; i < primes.length; i++) {
      pq.add(new Pair(primes[i], 1, primes[i]));
    }
    dp[1] = 1;
    for (int i = 2; i <= n;) {
      Pair temp = pq.poll();
      if (temp.value != dp[i - 1]) {
        dp[i] = temp.value;
        i++;
      }
      pq.add(new Pair(temp.prime, temp.pointer + 1, temp.prime * dp[temp.pointer + 1]));
    }

    return dp[n];
  }
}
