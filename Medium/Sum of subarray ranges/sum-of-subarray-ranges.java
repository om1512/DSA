//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {

            int N;
            N = sc.nextInt();

            int[] arr = new int[N];
            for (int i = 0; i < N; i++) arr[i] = sc.nextInt();

            Solution obj = new Solution();
            long res = obj.subarrayRanges(N, arr);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


class Solution {
    public static long subarrayRanges(int N, int[] nums) {
        // code here
        long ans = 0;
        for(int i=0;i<nums.length;i++){
          int min = nums[i],max = nums[i];
          for(int j=i+1;j<nums.length;j++){
            if(nums[j] > max) max = nums[j];
            if(nums[j] < min) min = nums[j];
            ans += (max-min);
          }
        }      
        return ans;
    }
}
