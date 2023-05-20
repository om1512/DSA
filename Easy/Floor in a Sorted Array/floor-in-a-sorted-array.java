//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Searching
{
    public static void main (String[] args)throws IOException {

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
           String a[] = read.readLine().trim().split("\\s+");
           int n = Integer.parseInt(a[0]);
           long x = Long.parseLong(a[(int)1]);
           String st[] = read.readLine().trim().split("\\s+");
        
           long arr[] = new long[n];
           for(int i = 0; i < n; i++)
           {
               arr[i] = Long.parseLong(st[i]);
           }
           
           out.println(new Solution().findFloor(arr, n, x));
          
        }
        out.close();
    }
    
}
// } Driver Code Ends


class Solution{
    
    // Function to find floor of x
    // arr: input array
    // n is the size of array
    static int findFloor(long nums[], int n, long target)
    {
        long max = Integer.MIN_VALUE;
        int index = -1;
        int left = 0;
        int right = n - 1;
        int mid = (left + right) / 2;
        while (left <= right) {
          if (nums[mid] == target) {
            return mid;
          } else if (nums[mid] < target) {
            left = mid + 1;
            max = Math.max(max, nums[mid]);
            index = mid;
          } else {
            right = mid - 1;
          }
          mid = (left + right) / 2;
        }
        return index;
    }
    
}
