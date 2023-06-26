//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            System.out.println(
                new Solution().infixToPostfix(br.readLine().trim()));
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to convert an infix expression to a postfix expression.
    
    
    static int precedence(char c) {
        switch(c){
          case '+':
          case '-':
            return 1;
          case '*':
          case '/':
            return 2;
          case '^':
            return 3;
        }
        return -1;
      }
  
    public static String infixToPostfix(String s) {
        Stack<Character> stack = new Stack<>();
        String result = "";
        for (int i = 0; i < s.length(); i++) {
          char c = s.charAt(i);
          if (Character.isLetterOrDigit(c))
            result += c;
          else if (c == '(')
            stack.push('(');
          else if (c == ')') {
            while (stack.peek() != '(') {
              result += stack.pop();
            }
            stack.pop();
          }else{
            while(!stack.isEmpty() && precedence(c) <= precedence(stack.peek())){
              result+=stack.pop();
            }
            stack.push(c);
          }
        }
        while(!stack.isEmpty()){
          result+=stack.pop();
        }
        return result;
    }
}