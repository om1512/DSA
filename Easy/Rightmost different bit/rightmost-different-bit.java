//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.BigInteger;

class Main{
    
    
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc=new Scanner(System.in);
		
		//input number of testcases
		int t=sc.nextInt();
		int m,n;
		while(t-->0) {
		    
		    
            Solution obj = new Solution();
            //input m and n
		    m = sc.nextInt();
		    n = sc.nextInt();
		    System.out.println(obj.posOfRightMostDiffBit(m, n));
		}
	}
}




// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find the first position with different bits.
    public static int posOfRightMostDiffBit(int m, int n)
    {
            
        String a = Integer.toString(m,2);
        String b = Integer.toString(n,2);
        if(a.equals(b)) return -1;
        int i = a.length() - 1;
        int j = b.length() - 1;
        int index = 1;
        while(i >= 0 && j >= 0){
            if(a.charAt(i) != b.charAt(j)){
                return index;
            }
            index++;
            i--;
            j--;
        }
        return index;
    }
}


// 100
//1000

