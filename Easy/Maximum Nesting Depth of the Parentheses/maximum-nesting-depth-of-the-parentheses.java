//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            sc.nextLine();
            String s;
            s = sc.next();
            
            Solution obj = new Solution();
            int res = obj.maxDepth(s);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int maxDepth(String s) {
        int maxdepth = Integer.MIN_VALUE;
        char[] c = s.toCharArray();
        int open = 0;
        int pair = 0;
        for(char i:c){
            if(i == '('){
                open++;
            }else if(i == ')'){
                if(open >0) open--;
            }
            pair = Math.max(pair,open);
            if(open == 0){
                maxdepth = Math.max(maxdepth,pair);
                pair = 0;
            }
        }
        return maxdepth;
    }
}
        
