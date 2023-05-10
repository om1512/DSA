//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Geeks
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n =sc.nextInt();
            int arr[] = new int[n];
            
            for(int i = 0; i < n; i++)
             arr[i] = sc.nextInt();
             
           System.out.println(new Solution().majorityElement(arr, n)); 
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    static int majorityElement(int a[], int size)
    {
       
        int val = -1;
        Map<Integer,Integer> m = new HashMap<>();
        for(int i:a){
            m.put(i, m.getOrDefault(i,0)+1);
        }
        
        for(Map.Entry<Integer,Integer> i : m.entrySet()){
         if((size/2) < i.getValue()){
                val = i.getKey();
              }       
        }
        
        return val;
    
    }
}