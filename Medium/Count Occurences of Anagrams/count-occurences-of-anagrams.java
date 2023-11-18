//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String txt = br.readLine().trim();
            String pat = br.readLine().trim();

            int ans = new Solution().search(pat, txt);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    int search(String pat, String txt) {
        // code here
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < pat.length(); i++) {
          map.put(pat.charAt(i), map.getOrDefault(pat.charAt(i), 0) + 1);
        }
        int i = 0, j = 0, k = pat.length(), count = map.size(), ans = 0;
        while (j < txt.length()) {
          if (map.containsKey(txt.charAt(j))) {
            int a = map.get(txt.charAt(j));
            map.put(txt.charAt(j), --a);
            if (a == 0) {
              count--;
            }
          }
          if (j - i + 1 < k) {
            j++;
            continue;
          }
          if (j - i + 1 == k) {
            if (count == 0) {
              ans++;
            }
            if (map.containsKey(txt.charAt(i))) {
              int a = map.get(txt.charAt(i));
              if (a == 0) {
                count++;
              }
              map.put(txt.charAt(i), ++a);
            }
          }
          i++;
          j++;
        }
        return ans;
    }
}