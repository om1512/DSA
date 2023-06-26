//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            sc.nextLine();
            String s = sc.next();
            Solution obj = new Solution();
            String ans = obj.postToInfix(s);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static String postToInfix(String s) {
        Stack<String> stack  = new Stack<>();
        for(int i=0;i<s.length();i++){
          char ch = s.charAt(i);
          if(Character.isLetterOrDigit(ch)) stack.push(Character.toString(ch));
          else{
            String b = stack.pop();
            String a = stack.pop();
            stack.push("("+a+ch+b+")");
          }
        }
        return stack.pop();
    }
}
