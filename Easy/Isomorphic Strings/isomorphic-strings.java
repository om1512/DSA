//{ Driver Code Starts
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.*;


public class Driver {
    
    public static void main(String[] args)throws IOException {
       
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while(tc-->0)
        {
            String s1 = br.readLine();
            String s2 = br.readLine();
            
            Solution obj = new Solution();
            
            boolean a = obj.areIsomorphic(s1,s2);
            if(a)
            System.out.println(1);
            else
            System.out.println(0);
        }
    }
    
}

// } Driver Code Ends


class Solution
{
    //Function to check if two strings are isomorphic.
    public static boolean areIsomorphic(String s1,String s2)
    {
          int[] m1 = new int[200];
          int[] m2 = new int[200];
          if(s1.length() != s2.length()){
            return false;
          }
          for(int i=0;i<s1.length();i++){
            if(m1[s1.charAt(i)] != m2[s2.charAt(i)]){
              return false;
            }
            m1[s1.charAt(i)]=i+1;
            m2[s2.charAt(i)]=i+1;
          }
          return true;
    }
}