class Solution {
    public static boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();
    char[] c = s.toCharArray();
    for (char ch : c) {
      if (ch == '(' || ch == '{' || ch == '[') {
        stack.push(ch);
      } else if (ch == ')') {
        if(stack.isEmpty()) return false;
        if (stack.peek() != '(') {
          return false;
        } else {
          stack.pop();
        }
      } else if (ch == ']') {
        if(stack.isEmpty()) return false;
        if (stack.peek() != '[') {
          return false;
        } else {
          stack.pop();
        }
      } else if (ch == '}') {
        if(stack.isEmpty()) return false;
        if (stack.peek() != '{') {
          return false;
        } else {
          stack.pop();
        }
      }
    }
    if (stack.isEmpty()) {
      return true;
    }
    return false;
  }
}