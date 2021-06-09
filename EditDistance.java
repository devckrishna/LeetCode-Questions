class EditDistance {
  public int minDistance(String word1, String word2) {
    int[][] dp = new int[word1.length() + 1][word2.length() + 1];
    for (int i = 0; i <= word2.length(); i++) {
      dp[0][i] = i;
    }
    for (int i = 1; i <= word1.length(); i++) {
      dp[i][0] = i;
      for (int j = 1; j <= word2.length(); j++) {
        int insert = dp[i][j - 1] + 1;
        int delete = dp[i - 1][j] + 1;
        int replace = dp[i - 1][j - 1];
        replace += (word1.charAt(i - 1) == word2.charAt(j - 1) ? 0 : 1);
        dp[i][j] = Math.min(replace, Math.min(insert, delete));
      }
    }
    return dp[word1.length()][word2.length()];
  }

}