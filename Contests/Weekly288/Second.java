public class Second {
  public String minimizeResult(String s) {
    int plus = -1;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '+') {
        plus = i;
        break;
      }
    }
    String[] w = s.split("\\+");
    int val = Integer.parseInt(w[0]) + Integer.parseInt(w[1]);
    String curr = "";
    for (int i = 0; i < plus; i++) {
      for (int j = plus + 2; j <= s.length(); j++) {
        String first = s.substring(0, i);
        String first2 = s.substring(i, plus);
        String second = s.substring(plus, j);
        String second2 = s.substring(j, s.length());
        String temp = first + "(" + first2 + second + ")" + second2;

        int currVal = solve(temp);
        System.out.println(temp + " " + currVal + " " + val);
        if (currVal <= val) {
          val = currVal;
          curr = temp;
        }
      }
    }
    return curr;
  }

  public int solve(String s) {
    int first = 0;
    int second = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(') {
        second = i;
        break;
      }
    }
    String prevbracket = s.substring(first, second);
    int third = -1;
    int fourth = s.length();
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == ')') {
        third = i;
        break;
      }
    }
    String postBracket = s.substring(third + 1, fourth);
    String[] curr = s.substring(second + 1, third).split("\\+");
    int ans = Integer.parseInt(curr[0]) + Integer.parseInt(curr[1]);
    System.out.println(ans);
    ans *= prevbracket == "" ? 1 : Integer.parseInt(prevbracket);
    ans *= postBracket == "" ? 1 : Integer.parseInt(postBracket);
    return ans;
  }
}
