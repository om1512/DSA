//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntMatrix
{
    public static int[][] input(BufferedReader br, int n, int m) throws IOException
    {
        int[][] mat = new int[n][];

        for(int i = 0; i < n; i++)
        {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for(int j = 0; j < s.length; j++)
                mat[i][j] = Integer.parseInt(s[j]);
        }

        return mat;
    }

    public static void print(int[][] m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }

    public static void print(ArrayList<ArrayList<Integer>> m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int N;
            N = Integer.parseInt(br.readLine());
            
            
            int[][] matrix = IntMatrix.input(br, N, N);
            
            Solution obj = new Solution();
            int res = obj.findMinOperation(N, matrix);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends



class Solution {
    public static int findMinOperation(int N, int[][] matrix) {
        int row[] = new int[N];
        int column[] = new int[N];
        int ans = 0;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                row[i] += matrix[i][j];
                column[i] += matrix[j][i];
                max = Integer.max(max,Integer.max(row[i],column[i]));
            }
        }
        
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                int element = matrix[i][j];
                int remaining = max - (Integer.max(row[i],column[j]));
                ans += remaining;
                matrix[i][j] += remaining;
                row[i] += remaining;
                column[j] += remaining;
            }
        }
        return ans;
    }
}
        
