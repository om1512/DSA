//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            int d;
            d = Integer.parseInt(br.readLine());
            
            
            int[] arr = IntArray.input(br, n);
            
            Solution obj = new Solution();
            int res = obj.countPartitions(n, d, arr);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends



class Solution {
    public static int perfectSum(int arr[],int n, int sum) 
    { 
        int[][] dp = new int[n+1][sum+1];
	    dp[0][0] = 1;
        for(int i=1;i<=n;i++){
            for(int j=0;j<=sum;j++){
                
                if(arr[i-1]>j){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = (dp[i-1][j] + dp[i-1][j-arr[i-1]]) % 1000000007;
                }
                
            }
            
        }
        
        return dp[n][sum];
    } 
    public static int countPartitions(int n, int d, int[] arr) {
        // code here
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        int sum1 = (sum + d)/2;
        if(sum1 - (sum-sum1) != d) return 0;
        return perfectSum(arr, n, sum1);
    }
}
        
