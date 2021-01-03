import java.util.*;

class KeyPadCodes {

  public static List<String> solve(String[] codes, String ques) {
    if (ques.length() == 0) {
      List<String> base = new ArrayList<>();
      base.add("");
      return base;
    }
    String roq = ques.substring(1);
    List<String> recAns = solve(codes, roq);
    List<String> myAns = new ArrayList<>();
    int num = ques.charAt(0) - '0';
    String word = codes[num];
    for (int i = 0; i < word.length(); i++) {
      char ch = word.charAt(i);
      for (int j = 0; j < recAns.size(); j++) {
        myAns.add(ch + recAns.get(j));
      }
    }
    return myAns;
  }

  public List<String> letterCombinations(String digits) {
    String[] codes = { ",.;", " ", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
    if (digits.length() == 0) {
      return new ArrayList<>();
    }
    return solve(codes, digits);
  }
}