//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if(ob.isSubsetSum(N, arr, sum))
            System.out.println(1);
            else
            System.out.println(0);

            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{

    // recursive approch
    // static Boolean isSubsetSum(int N, int arr[], int sum){
    //     if(sum == 0) return true;
    //     if(N == 0) return false;
    //     return (isSubsetSum(N-1, arr, sum - arr[N-1]) || isSubsetSum(N-1, arr, sum));
    // }
    
    // recursion + memoization = top down approch
    static Boolean solve(int N, int arr[], int sum, Boolean[][] dp){
        
        if(sum == 0)return true;
        if(N <= 0 || sum < 0) return false;

        if(dp[N][sum] != null) return dp[N][sum];
        if(sum >= arr[N-1])
            return dp[N][sum] = (solve(N-1, arr, sum - arr[N-1], dp) || solve(N-1, arr, sum, dp));
        return dp[N][sum] = solve(N-1, arr, sum, dp);
    }

    static Boolean isSubsetSum(int N, int arr[], int sum){
        Boolean dp[][] = new Boolean[N+1][sum+1];
        for(int i = 0; i < N+1 ; i++){
            for(int j = 0; j < sum+1 ; j++){
                dp[i][j] = null;
            }
        }
        return solve(N, arr, sum, dp);
    }
}