//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 


class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0){
            int n = sc.nextInt(); 
            int arr[] = new int[n];
            for (int i = 0; i < n; ++i)
            {
                arr[i] = sc.nextInt();
            }
            Solution obj = new Solution();
            int []ans= obj.sortArr(arr, n);
            for(int i=0;i<n;i++)
            {
                System.out.print(ans[i]+" ");
            }
            System.out.println();
        }
        
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
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
    int[] sortArr(int[] arr, int n) 
    { 
        // code here
        QuickSort(arr,0,n-1);
        return arr;
    }
} 