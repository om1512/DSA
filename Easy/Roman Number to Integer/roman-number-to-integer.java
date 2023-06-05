//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String roman = br.readLine().trim();
            Solution ob = new Solution();
            System.out.println(ob.romanToDecimal(roman));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    // Finds decimal value of a given roman numeral
    public int romanToDecimal(String str) {
        char[] c = str.toCharArray();
        int ans = 0;
        for(int i=c.length-1;i>=0;i--){
            switch(c[i]){
                case 'I':
                    if(ans>=5) ans-=1;
                    else ans+=1;
                    break;
                case 'V':
                    if(ans>=10) ans-=5;
                    else ans+=5;
                    break;
                case 'X':
                    if(ans>=50) ans-=10;
                    else ans+=10;
                    break;
                case 'L':
                    if(ans>=100) ans-=50;
                    else ans+=50;
                    break;
                case 'C':
                    if(ans>=500) ans-=100;
                    else ans+=100;
                    break;
                 case 'D':
                    if(ans>=1000) ans-=500;
                    else ans+=500;
                    break;
                 case 'M':
                    ans+=1000;
                    break;
            }
        }
        return ans;
    }
}