//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());

            long ans = new Solution().countStrings(n);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    long countStrings(int n) {
        long[] dp = new long[n+1];
        dp[0] = 1;
        dp[1] = 2;
        for(int i=2;i<n+1;i++){
            dp[i] = (long) ((dp[i-1] + dp[i-2]) % (Math.pow(10,9) + 7));
        }
        return dp[n];
    }
}

// 0 1 2 3 4 5
// 1 2 3 5 8 13