//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            Solution ob = new Solution();
            System.out.println(ob.binaryNextNumber(s));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    String binaryNextNumber(String s) {
        StringBuilder str = new StringBuilder(s);
        while(str.length() > 1 && str.charAt(0) == '0'){
            str.deleteCharAt(0);
        }
        if(str.charAt(str.length() - 1) == '0'){
            str.setCharAt(str.length() -1, '1');
            return str.toString();
        }
        
        int i = str.length() - 1;
        while(i >= 0 && str.charAt(i) == '1'){
            str.setCharAt(i, '0');
            i--;
        }
        if(i >= 0) {
            str.setCharAt(i, '1');
            return str.toString();
        }
        return "1" + str.toString();
    }
}