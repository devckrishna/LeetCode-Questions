package StacksAndQueues;

import java.util.*;

class MinRemoveToMakeValid {
  public String minRemoveToMakeValid(String s) {
    Stack<Integer> st = new Stack<>();
    char[] str = s.toCharArray();
    for (int i = 0; i < str.length; i++) {
      char ch = str[i];
      if (ch == ')') {
        if (st.isEmpty()) {
          str[i] = '\0';
        } else {
          st.pop();
        }
      } else if (ch == '(') {
        st.push(i);
      }

    }
    while (!st.isEmpty()) {
      str[st.pop()] = '\0';
    }
    StringBuilder sb = new StringBuilder("");
    for (int i = 0; i < str.length; i++) {
      if (str[i] != '\0') {
        sb.append(str[i]);
      }
    }
    return sb.toString();
  }
}