//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
            Solution obj = new Solution();
            int res = obj.countRevPairs(N, arr);
            System.out.println(res);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static int merge(int[] arr,int l,int m,int r){
        int count = 0;
        int m1= m-l+1;
        int m2= r-m;
        int[] left = new int[m1];
        int[] right = new int[m2];
        for(int i=0;i<m1;i++){
            left[i] = arr[l+i];
        }
        for(int i=0;i<m2;i++){
            right[i] = arr[m+1+i];
        }
        int i = 0,j = 0;
        while(i < m1 && j < m2){
            if(left[i] > 2*right[j]){
                count+=m1-i;
                j++;
            }else{
                i++;
            }
        }
        i = 0;
        j = 0;
        int k = l;
        while (i < m1 && j < m2) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < m1) {
            arr[k++] = left[i++];
        }

        while (j < m2) {
            arr[k++] = right[j++];
        }
        return count;
    }

    static int mergeSort(int[] arr,int l,int r){
        if(r <= l) return 0;
        int m = (l+r)/2;
        int c = mergeSort(arr,l,m);
        c += mergeSort(arr,m+1,r);
        c += merge(arr,l,m,r);
        return c;
    }

  
    public int countRevPairs(int N, int arr[]) {
        return mergeSort(arr,0,N-1);
    }
}