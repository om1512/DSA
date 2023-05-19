//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Sorting
{
    public static void main (String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        
        while(t-- > 0)
        {
            long n = sc.nextLong();
            long arr[] = new long[(int)n];
            
            for(long i = 0; i < n; i++)
             arr[(int)i] = sc.nextLong();
             
            System.out.println(new Solution().inversionCount(arr, n));
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    
    static long merge(long arr[], int l, int m, int r) {
    long count = 0;
    int m1 = m - l + 1;
    int m2 = r - m;
    long[] left = new long[m1];
    long[] right = new long[m2];
    for (int i = 0; i < m1; i++) {
      left[i] = arr[l + i];
    }
    for (int j = 0; j < m2; j++) {
      right[j] = arr[m + 1 + j];
    }

    int i = 0;
    int j = 0;
    int k = l;
    while (i < m1 && j < m2) {
      if (left[i] <= right[j]) {
        arr[k] = left[i];
        i++;
      } else {
        arr[k] = right[j];
        count+=(m1-i);
        j++;
      }
      k++;
    }

    while (i < m1) {
      arr[k] = left[i];
      i++;
      k++;
    }

    while (j < m2) {
      arr[k] = right[j];
      j++;
      k++;
    }

    return count;
  }

  static long mergeSort(long arr[], int l, int r) {
      if(r <= l) return 0;
      int m = (l + r) / 2;
      long count = mergeSort(arr, l, m);
      count += mergeSort(arr, m + 1, r);
      count += merge(arr, l, m, r);
    
    return count;
  }
    static long inversionCount(long arr[], long N)
    {
        return mergeSort(arr,0,(int)N-1);
    }
}