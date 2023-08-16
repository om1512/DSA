//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    
		    int arr[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    arr[i]=sc.nextInt();
		    
		    int k=sc.nextInt();
		    Solution ob = new Solution();
		    out.println(ob.kthSmallest(arr, 0, n-1, k));
		}
		out.flush();
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    
    static void swap(int[] arr,int p,int q){
        int temp  = arr[p];
        arr[p] = arr[q];
        arr[q] = temp;
    }
    static void QuickSort(int[] arr,int p,int r){
        if(p < r){
            int pivot = Pivot(arr,p,r);
            QuickSort(arr,p,pivot-1);
            QuickSort(arr,pivot+1,r);
        }
    }
    static int Pivot(int[] arr,int p,int r){
        int pivot = arr[p];
        int i = p;
        int j = r;
        while(i < j){
            while(i<=r && arr[i] <= pivot){
                i++;
            }
            while(arr[j] > pivot){
                j--;
            }
            if(i<j){
                swap(arr,i,j);
            }
        }
        swap(arr,j,p);
        return j;
    }
    public static int kthSmallest(int[] arr, int l, int r, int k) 
    { 
        //Your code here
        QuickSort(arr,l,r);
        return arr[k-1];
    } 
}
