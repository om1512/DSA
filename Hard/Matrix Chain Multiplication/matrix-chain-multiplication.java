//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.matrixMultiplication(N, arr));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int solve(int[] arr,int i,int j,int min,int[][] t) {
        if(i >= j){
            return 0;
        }
        for(int k=i;k<j;k++){
            if(t[i][k] == 0){
                t[i][k] = solve(arr,i,k,min,t);
            }
            if(t[k+1][j] == 0){
                t[k+1][j] = solve(arr,k+1,j,min,t);
            }

            int temp = t[i][k]  + t[k+1][j] + (arr[i-1] * arr[k] * arr[j]);
            min = Math.min(min,temp);
        }
        return min;
    }
    static int matrixMultiplication(int N, int arr[])
    {
        return solve(arr,1,N-1,Integer.MAX_VALUE, new int[N+1][N+1]);
    }
}