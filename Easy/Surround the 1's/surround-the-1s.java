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
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] matrix = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++)
                    matrix[i][j] = Integer.parseInt(S[j]);
            }
            Solution ob = new Solution();
            int ans = ob.Count(matrix);
            out.println(ans);
        }
        out.close();
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public static int rows;
    public static int colums;
    static boolean isvalid(int[][] matrix,int i,int j){
        int zeroCount = 0;
        
        // for left element
        if(j-1 >= 0 && matrix[i][j-1] == 0) zeroCount+=1;
        
        // for right element
        if(j+1 < colums && matrix[i][j+1] == 0) zeroCount+=1;
        
        // for top element
        if(i-1 >= 0 && matrix[i-1][j] == 0) zeroCount+=1;
        
        // for bottom element
        if(i+1 < rows && matrix[i+1][j] == 0) zeroCount+=1;
        
        // for topLeft element
        if(i-1 >= 0 && j-1 >= 0 && matrix[i-1][j-1] == 0) zeroCount+=1;
        
        // for topRight element
        if(i-1 >= 0 && j+1 < colums && matrix[i-1][j+1] == 0) zeroCount+=1;
        
        // for bottomRight element
        if(i+1 < rows && j-1 >= 0 && matrix[i+1][j-1] == 0) zeroCount+=1;
        
        // for Right element
        if(i+1 < rows && j+1 < colums && matrix[i+1][j+1] == 0) zeroCount+=1;
        
        
        return (zeroCount > 0 && zeroCount % 2 == 0) ? true : false;
        
        
    }
    public int  Count(int[][] matrix)
    {
        rows = matrix.length;
        colums = matrix[0].length;
        
        
        int ans =  0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<colums;j++){
                if(matrix[i][j] == 1 && isvalid(matrix,i,j)){
                    ans++;
                }
            }
        }
        
        return ans;
    }
}