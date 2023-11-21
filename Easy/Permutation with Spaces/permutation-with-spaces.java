//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S = read.readLine().trim();
            Solution ob = new Solution();
            ArrayList<String> ans = new ArrayList<String>();
            ans = ob.permutation(S);
            
            for(int i=0;i<ans.size();i++){
                System.out.print("("+ans.get(i)+")");
            }
            System.out.println();
        }
    }
}


// } Driver Code Ends


//User function Template for Java



class Solution{
    
    public static ArrayList<String> permutations(StringBuilder in, StringBuilder op, int index, ArrayList<String> ans) {
        if (index == in.length()) {
        ans.add(op.toString());
        return ans;
        }
        StringBuilder st1 = new StringBuilder(op);
        st1.append(in.charAt(index));
        permutations(in, st1, index + 1, ans);
        StringBuilder st2 = new StringBuilder(op);
        st2.append(" ").append(in.charAt(index));
        permutations(in, st2, index + 1, ans);
        return ans;
    }
    ArrayList<String> permutation(String s){
        // Code Here
        ArrayList<String> ans = permutations(new StringBuilder(s), new StringBuilder(String.valueOf(s.charAt(0))), 1,
        new ArrayList<>());

        Collections.reverse(ans);
        return ans;
    }
    
}