//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String inline[] = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(inline[0]);
            int m = Integer.parseInt(inline[1]);
            String inline1[] = in.readLine().trim().split("\\s+");
            int M[][] = new int[n][m];
            for(int i = 0;i < n*m;i++){
                M[i/m][i%m] = Integer.parseInt(inline1[i]);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.maxGold(n, m, M));
        }
    }
} 
// } Driver Code Ends


//User function Template for Java

class Solution{
    
        public static int solve(int[][] matrix,int i, int j,int[][] r){
        int is = matrix.length;
        int js = matrix[0].length;

        if (i < 0 || i >= is || j < 0 || j >= js) {
            return 0;
        }
        if (r[i][j] > 0) {
            return r[i][j];
        }

        int moveRight = solve(matrix,i,j+1,r);
        int moveDiagonalUp = solve(matrix,i-1,j+1,r);
        int moveDiagonalDown = solve(matrix,i+1,j+1,r);

        return r[i][j] = matrix[i][j] + Math.max(moveRight, Math.max(moveDiagonalUp, moveDiagonalDown));
    }

  
    static int maxGold(int n, int m, int matrix[][])
    {
        int[][] r = new int[n+1][m+1];
        int max = 0;
        for(int i=0;i<n;i++){
            max = Math.max(max,solve(matrix, i, 0, r));
        }
        return max;
    }
}
