public class MultiplyStrings {
  public String multiply(String num1, String num2) {
    if (num2.length() == 1 && num2.charAt(0) == '0') {
      return "0";
    }
    if (num1.length() == 1 && num1.charAt(0) == '0') {
      return "0";
    }
    int[] prod = new int[num1.length() + num2.length()];
    for (int i = num1.length() - 1; i >= 0; i--) {
      for (int j = num2.length() - 1; j >= 0; j--) {
        int val = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
        prod[i + j + 1] += val;
      }
    }
    int carry = 0;
    for (int i = prod.length - 1; i >= 0; i--) {
      int temp = (prod[i] + carry) % 10;
      carry = (prod[i] + carry) / 10;
      prod[i] = temp;
    }
    StringBuilder sb = new StringBuilder();
    for (int num : prod) {
      sb.append(num);
    }
    if (sb.length() != 0 && sb.charAt(0) == '0') {
      sb.deleteCharAt(0);
    }
    return sb.length() == 0 ? "0" : sb.toString();
  }
}
