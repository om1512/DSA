//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int x = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().count(arr, n, x);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java



class Solution {
    int count(int[] arr, int n, int x) {
        // code here
        int left =0, right = n-1, mid = (left+right)/2;
        int start = -1,end = -1;
        while(left <= right){
            mid = (left+right)/2;
            if(arr[mid] == x){
                start = mid;
                right = mid-1;
            }else if(arr[mid]<x){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        left =0;
        right = n-1;
        while(left <= right){
            mid = (left+right)/2;
            if(arr[mid] == x){
                end = mid;
                left = mid+1;
            }else if(arr[mid]<x){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        if(end == -1 && start == -1){
            return 0;
        }
        return (end-start)+1;
    }
}