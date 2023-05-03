//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            Solution obj = new Solution();
            obj.printTriangle(n);
        }
    }
}
// } Driver Code Ends


class Solution {

    void printTriangle(int n) {
        // code here
        int space = 2*(n-1);
         for(int i=1;i<=n;i++){
             //number
             for(int j=1;j<=i;j++){
                 System.out.print(j+" ");
             }
             
             //space
             for(int j=space;j>0;j--){
                 System.out.print("  ");
             }
             
             //number
             for(int j=i;j>0;j--){
                 System.out.print(j + " ");
             }
             System.out.println();
             space-=2;
         }
        
    }
}