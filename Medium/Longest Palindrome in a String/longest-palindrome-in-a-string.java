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
            String S = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.longestPalin(S));
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution {
    int maxLen=0, st = 0;
    public String longestPalin(String s) {
        int n = s.length();
        char[] c = s.toCharArray();
        if(n<2) return s;
        for(int i=0;i<n;i++){
            expand(c,i,i);
            expand(c,i,i+1);
        }
        return s.substring(st,st+maxLen);
    }
    void expand(char[] c,int l,int r){
            while(l>=0 && r<c.length && c[l] == c[r]){
                l--;
                r++;
            }
            if((r-l-1) > maxLen){
                maxLen= (r-l-1);
                st = l+1;
            }
    }
}