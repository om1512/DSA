//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            String s = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.reverseWords(s));
            t--;
        }
    }
}

// } Driver Code Ends



class Solution 
{
    //Function to reverse words in a given string.
    String reverseWords(String s)
    {
        // code here
        String ans = "";
        String[] strArray = s.split("[.]");
        for(int i=strArray.length-1;i>=1;i--){
            ans += (strArray[i]) + ".";
        }
        return ans + strArray[0];
    }
}