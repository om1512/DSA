//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            ArrayList<String> result = ob.NBitBinary(n);
            for(String value  : result){
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    
    public static ArrayList<String> nBit(int one, int zeros, StringBuilder output, int n,
      ArrayList<String> ans) {
        if (n == 0) {
          ans.add(output.toString());
          return ans;
        }
        StringBuilder str = new StringBuilder(output);
        str.append("1");
        nBit(one + 1, zeros, str, n - 1, ans);
        if (one > zeros) {
          StringBuilder str1 = new StringBuilder(output);
          str1.append("0");
          nBit(one, zeros + 1, str1, n - 1, ans);
        }
    
        return ans;
      }
  
    ArrayList<String> NBitBinary(int N) {
        return nBit(1, 0, new StringBuilder("1"), N-1, new ArrayList<>());
    }
}