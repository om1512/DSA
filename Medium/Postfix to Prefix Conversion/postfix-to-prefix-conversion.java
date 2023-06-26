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
            String ans = obj.postToPre(s);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static String postToPre(String s) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
          char ch = s.charAt(i);
          if (Character.isLetterOrDigit(ch))
            stack.push(Character.toString(ch));
          else {
            String a = stack.pop();
            String b = stack.pop();
            stack.push(ch+b+a);
          }
        }
        return stack.pop();
    }
}
