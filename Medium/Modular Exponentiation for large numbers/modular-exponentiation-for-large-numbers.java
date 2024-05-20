//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String s = br.readLine();
            String[] S = s.split(" ");
            long x = Long.parseLong(S[0]);
            long n = Long.parseLong(S[1]);
            long m = Long.parseLong(S[2]);
            Solution ob = new Solution();
            long ans = ob.PowMod(x, n, m);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public long PowMod(long x, long n, long m)
    {
        // String binary = Long.toBinaryString(n);
        // long sum = x;
        // for(int i=1;i<binary.length();i++){
        //     if(binary.charAt(i) == '0'){
        //         sum = ((long)Math.pow(sum,2)) % m;
        //     }else{
        //         sum = ((long)Math.pow(sum,2)) % m;
        //         sum = (sum * x) % m;
        //     }
        // }
        // return sum;
        
        long result = 1;
        x = x % m;  // Update x if it is more than or equal to m
        while (n > 0) {
            // If n is odd, multiply x with the result
            if ((n & 1) == 1) {
                result = (result * x) % m;
            }
            n = n >> 1;  // n = n/2
            x = (x * x) % m;  // Change x to x^2
        }
        return result;
    }
}