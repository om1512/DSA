//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String str = in.readLine();
            Solution ob = new Solution();
            System.out.println(ob.palindromicPartition(str));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
      static int solve(String s,int i,int j,int[][] dp,int min){
        if(i>=j){
            return 0;
        }
        if(isP(s,i,j)==true){
            return 0;
        }
        for(int k=i;k<j;k++){
            if(dp[i][k]==0){
                dp[i][k] = solve(s,i,k,dp,min);
            }
            if(dp[k+1][j] == 0){
                dp[k+1][j] = solve(s,k+1,j,dp,min);
            }
            int temp = 1+dp[i][k]+dp[k+1][j];
            min = Math.min(min,temp);
        }
        return dp[i][j]=min;
    }
    public static int palindromicPartition(String str){
        int i = 0;
        int j = str.length()-1;
        int min = Integer.MAX_VALUE;
        int[][] dp = new int[501][501];
        return solve(str,i,j,dp,min);
    }
    static boolean isP(String s,int i,int j){
        while(j>=i){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            else{
                j--;
                i++;
            }
        }
        return true;
    }

}