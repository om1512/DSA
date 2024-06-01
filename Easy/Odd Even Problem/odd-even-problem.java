//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String s;
            s = br.readLine();

            Solution obj = new Solution();
            String res = obj.oddEven(s);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends



class Solution {
    public static String oddEven(String s) {
        // code here
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c:s.toCharArray()){
            map.put(c, map.getOrDefault(c,0) + 1);
        }
        int[] ans = new int[2];
        map.forEach((key, value) -> {
            if(key % 2 == 0 && value % 2 == 0){
                ans[0]++;
            }else if(key % 2 != 0 && value % 2 != 0){
                ans[1]++;
            }
        });
        return (ans[0] + ans[1]) % 2 == 0 ? "EVEN" : "ODD";
    }
}
