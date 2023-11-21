//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String s = br.readLine().trim();
            Solution ob = new Solution();
            List<String> ans = ob.AllPossibleStrings(s);
            for(String i: ans)
                System.out.print(i + " ");
            System.out.println();
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public static List<String> subsetOfString(String input, String output, int index, List<String> ans) {
        if (index == input.length()) {
          if (!output.isEmpty()) {
            ans.add(output);
          }
          return ans;
        }
        String op1 = output;
        String op2 = output + input.charAt(index);
        index += 1;
        subsetOfString(input, op1, index, ans);
        subsetOfString(input, op2, index, ans);
        return ans;
    }
    public List<String> AllPossibleStrings(String s)
    {
        List<String> list = subsetOfString(s, "", 0, new ArrayList<>());
        Collections.sort(list);
        return list;
    }
}