//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            
            int n = Integer.parseInt(S[0]);
            int k = Integer.parseInt(S[1]);

            Solution ob = new Solution();
            System.out.println(ob.safePos(n,k));
        }
    }
}
// } Driver Code Ends


class Solution {
    public static int ans = 0;
    public static void josephusProblem(ArrayList<Integer> input, int start, int k) {
        if (input.size() == 1) {
          ans = input.get(0);
          return;
        }
        int indexToRemove = (start + k) % input.size();
        input.remove(indexToRemove);
        josephusProblem(input, indexToRemove, k);
      }
    static int safePos(int n, int k) {
        // code here
        ans = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
          list.add(i);
        }
        k -= 1;
        josephusProblem(list, n, k);
        return ans;
    }
};