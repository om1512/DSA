//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    int a[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        a[i]=sc.nextInt();
		    }
		    int m=sc.nextInt();
		    Solution ob = new Solution();
		    System.out.println(ob.findPages(a,n,m));
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution 
{
    static boolean isPossible(int[] a,int s,int mid){
        int stu = 1,m = 0;
        for(int i:a){
            if(i>mid){
                return false;
            }else if(m+i>mid){
                stu++;
                m= i;
            }else{
                m+=i;
            }
        }
        if(stu>s) return false;
        return true;
    }
    //Function to find minimum number of pages.
    public static int findPages(int[]A,int N,int M)
    {
        if(N<M){
            return -1;
        }
        int low = Integer.MAX_VALUE,high = 0;
        
        for(int i:A){
            low = Math.min(low,i);
            high += i;
        }
        int ans = high;
        while(low<=high){
            int mid = (low+high)/2;
            if(isPossible(A,M,mid)){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }
};