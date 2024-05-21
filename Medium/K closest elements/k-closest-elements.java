//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            inputLine = br.readLine().trim().split(" ");
            int k = Integer.parseInt(inputLine[0]);
            int x = Integer.parseInt(inputLine[1]);

            int[] ans = new Solution().printKClosest(arr, n, k, x);
            for (int xx : ans) {
                System.out.print(xx + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    int[] printKClosest(int[] arr, int n, int k, int x) {  
        TreeMap<Integer, List<Integer>> map =  new TreeMap<>();
        for(int i:arr){
            int diff = Math.abs(i - x);
            if(diff != 0){
                    List<Integer> aList = map.getOrDefault(diff, new ArrayList<>());
                    aList.add(i);
                    map.put(diff, aList);
            }
        }
        int[] ans = new int[k];
        int index[] = {0};
        map.forEach((key,v) -> {
            if(k > index[0]){
                Collections.reverse(v);
                for(int val:v){
                    if(k > index[0]){
                        ans[index[0]] = val;
                        index[0]++;
                    }
                }
            }
        });
        return ans;
    }
}
