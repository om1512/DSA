//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.swapNibbles(n));
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    
    static int swapNibbles(int n) {
        String str = Integer.toBinaryString(n);
        StringBuilder temp = new StringBuilder();
        while(temp.length() < 8 - str.length()){
            temp.append('0');
        }
        temp.append(str);
        String firstNibbel = temp.substring(0,4);
        String secondNibbel = temp.substring(4,8);
        String newString = secondNibbel + firstNibbel;
        return Integer.parseInt(newString, 2);
    }
}
