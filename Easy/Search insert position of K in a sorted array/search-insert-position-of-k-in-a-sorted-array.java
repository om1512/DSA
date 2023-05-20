//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int Arr[]= new int[N];
            for(int i = 0; i < N; i++)
                Arr[i] = Integer.parseInt(input_line[i]);
            int k = Integer.parseInt(read.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.searchInsertK(Arr, N, k));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    static int searchInsertK(int nums[], int n, int target)
    {
        int max = Integer.MIN_VALUE,
         index = -1,
         left = 0,
         right = n-1,
         mid = (left+right)/2;
        while(left <= right){
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] < target){
                left = mid+1;
                max = Math.max(max,nums[mid]);
                index = mid;
            }else{
                right = mid-1;
            }
            mid = (left+right)/2;
        }
        return index+1;
    }
}