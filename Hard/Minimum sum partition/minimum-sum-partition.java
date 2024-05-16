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
                    int A[] = new int[n];
                    for(int i = 0;i<n;i++)
                        A[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minDifference(A,n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public static ArrayList<Integer> subsetSumToK(int n, int k, int arr[]) {
        boolean[][] t = new boolean[n + 1][k + 1];
        ArrayList<Integer> list = new ArrayList<>();
        for (int j = 0; j < k + 1; j++) {
        t[0][j] = false;
        }
        for (int i = 0; i < n + 1; i++) {
        t[i][0] = true;
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < k + 1; j++) {
                if (arr[i - 1] <= j) {
                t[i][j] = (t[i - 1][j - arr[i - 1]] || t[i - 1][j]);
                } else {
                t[i][j] = t[i - 1][j];
                }
            }
        }
        for (int i = 0; i <= (k) / 2; i++) {
            if (t[n][i]) {
                list.add(i);
            }
        }
        return list;
    }

	public int minDifference(int nums[], int n) 
	{ 
	    int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        int min = Integer.MAX_VALUE;
        ArrayList<Integer> list = subsetSumToK(n, sum, nums);
        for (int i = 0; list.size() > 0 && i < list.size(); i++) {
            min = Math.min(min, sum - (2 * list.get(i)));
        }
        return min;
	} 
}
