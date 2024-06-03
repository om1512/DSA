//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.numberOfConsecutiveOnes(N));
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    public static int mod = (int)1e9+7; 
    // find all possiblities of that length
    public static int solve(int l, int status, int prev, int[][][] dp){
        if(l==0){
            if(status == 1) return 1;
            return 0;
        }
        if(dp[l][status][prev] != -1) return (dp[l][status][prev]) % mod;
        int t1 = 0, t2 = 0, t3 = 0;
        t1 = solve(l-1, status, 0, dp);
        if(prev == 1){
            t2 = solve(l-1, 1, 1, dp);
        }else{
            t3 = solve(l-1, status, 1, dp);
        }
        return dp[l][status][prev] = (t1 + t2 + t3)%mod;
    }
    static int numberOfConsecutiveOnes(int n) {
        // code here
        int[][][] dp = new int[n+1][2][2];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<2;j++){
                for(int k=0;k<2;k++){
                    dp[i][j][k] = -1;
                }
            }
        }
        return solve(n, 0, 0, dp);
    }
}
