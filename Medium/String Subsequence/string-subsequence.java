//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String s1;
            s1 = br.readLine();

            String s2;
            s2 = br.readLine();

            Solution obj = new Solution();
            int res = obj.countWays(s1, s2);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends



class Solution {
    static final int MOD = (int)1e9 + 7;

    public static int countWays(String s1, String s2) {
        // code here
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for(int i=0;i<=s1.length();i++){
            dp[i][0] = 1;
        }
        for(int i=1;i<=s1.length();i++){
            for(int j=1;j<=s2.length();j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = (dp[i-1][j] + dp[i-1][j-1]) % MOD;
                }else{
                    dp[i][j] = dp[i-1][j];   
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }
}
