//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            int w;
            w = Integer.parseInt(br.readLine());

            int[] cost = IntArray.input(br, n);

            Solution obj = new Solution();
            int res = obj.minimumCost(n, w, cost);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends



class Solution {
    static int solve(int[] cost, int index, int w, int[][] dp){
        if(w == 0) return 0;
        if(index == cost.length || w < 0){
            return Integer.MAX_VALUE;
        }
        if(dp[index][w] != -1) return dp[index][w];
        int take = Integer.MAX_VALUE;
        if(index+1 <= w){
            int temp = solve(cost, index, w-(index+1), dp);
            if(temp != Integer.MAX_VALUE){
                take = cost[index] + temp;
            }
        }
        int notTake = solve(cost, index+1, w, dp);
        return dp[index][w] = Math.min(take, notTake);
    }
    public static int minimumCost(int n, int w, int[] cost) {
        int[][] dp = new int[n][w+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<=w;j++){
                dp[i][j] = -1;
            }
        }
        return solve(cost, 0, w, dp);
    }
}
