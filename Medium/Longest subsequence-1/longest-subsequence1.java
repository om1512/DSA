//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            int[] a = IntArray.input(br, n);

            Solution obj = new Solution();
            int res = obj.longestSubseq(n, a);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends



class Solution {
    
    static int solve(int[] a, int index, int sum, int prev){
        if(index == a.length){
            return sum;
        }
        // either select it - only when prev is 0 or difference is 1
        int select = 0, notSelect = 0;
        if(prev == 0 || (Math.abs(a[index] - prev) == 1)){
            select = solve(a, index+1, sum+1, a[index]);
        }
        notSelect = solve(a, index+1, sum, prev);
        return Math.max(select, notSelect);
    }
    public static int longestSubseq(int n, int[] a) {
        // code here
        return solve(a, 0, 0, 0);
    }
}
