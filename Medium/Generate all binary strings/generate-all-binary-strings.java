//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while (T-- > 0) {
      int n = sc.nextInt();
      Solution obj = new Solution();
      List<String> ans = obj.generateBinaryStrings(n);
      for(String s : ans) System.out.print(s+" ");
      System.out.println();
    }
  }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    static List<String> solve(String ans,int n,List<String> ansList){
        if(n == 0){
            ansList.add(ans);
            return ansList;
        }
        String newAns = ans;
        newAns += "0";
        solve(newAns,n - 1,ansList);
        String newAns1 = ans;
        if(newAns1.isEmpty() || (!newAns1.isEmpty() && newAns1.charAt(newAns1.length() - 1) != '1')){
            newAns1 += "1";
            solve(newAns1,n - 1,ansList);
        }
        return ansList;
    }

  public static List<String> generateBinaryStrings(int n) {
    // code here
    return solve("",n,new ArrayList<>());
  }
}
     
     