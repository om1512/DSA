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
      int target = sc.nextInt();
      int a[] = new int[n];
      for(int i=0;i<n;i++){
        a[i]=sc.nextInt();
      }
      
      Solution obj = new Solution();
      int ans = obj.numberOfSubarrays(a, n, target);
      System.out.println(ans);
    }
  }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    int numberOfSubarrays(int nums[], int N, int goal){
        // code here
        Map<Integer,Integer> map = new HashMap<>();
        int sum = 0,count = 0;
        for(int i=0;i<N;i++){
          sum += nums[i];
          if(sum == goal){
            count++;
          }
          if(map.containsKey(sum-goal)) count+=map.get(sum-goal);
          map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        return count;
    }
}