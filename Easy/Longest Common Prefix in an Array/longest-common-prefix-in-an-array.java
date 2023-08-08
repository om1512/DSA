//{ Driver Code Starts
//Initial Template for Java

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
            int n = Integer.parseInt(read.readLine().trim());
            String arr[] = read.readLine().trim().split(" ");

            Solution ob = new Solution();
            System.out.println(ob.longestCommonPrefix(arr, n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    String longestCommonPrefix(String arr[], int length){
        // code here
        String ans = arr[0];
        if(length == 1) return ans;

        
        for(int i=1;i<length;i++){
            int n = Integer.min(ans.length(),arr[i].length());
            String temp = "";
            for(int k=0;k<n;k++){
                if(ans.charAt(k) == arr[i].charAt(k)){
                    temp += ans.charAt(k);
                }else{
                    break;
                }
            }
            ans = temp;
        }
        if(ans == "") return "-1";
        return ans;
    }
}