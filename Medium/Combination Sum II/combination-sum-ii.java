//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter ot = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String s[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int k = Integer.parseInt(s[1]);
            int a[] = new int[n];
            s = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);
            List<List<Integer>> ans = new Solution().CombinationSum2(a, n, k);
            for (List<Integer> list : ans) {
                for (int x : list) ot.print(x + " ");
                ot.println();
            }
            if (ans.size() == 0) ot.println();
        }
        ot.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public void solve(int index, int[] arr, int t, List<List<Integer>> ans, List<Integer> list){
        if(t == 0){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=index;i<arr.length;i++){
            if(i > index && arr[i-1] == arr[i]) continue;
            if(arr[i] > t) break;
            list.add(arr[i]);
            solve(i+1, arr, t - arr[i], ans, list);
            list.remove(list.size() - 1);
        }
    }
    public List<List<Integer>> CombinationSum2(int arr[], int n, int k) {
        Arrays.sort(arr);
        List<List<Integer>> list = new ArrayList<>();
        solve(0, arr, k, list, new ArrayList<>());
        return list;
    }
}
