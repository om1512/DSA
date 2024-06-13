//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.padovanSequence(n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
  public int padovanSequence(int n)
    {
       int mod=(int)1e9+7;
       int one=1;
       int two=1;
       int three=1;
       int ans=1;
       
       for(int i=3;i<=n;i++){
            ans=(one+two)%mod;
            one=two;
            two=three;
            three=ans;
       }
       
       return ans;
    }
    
}
