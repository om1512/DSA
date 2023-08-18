//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            int[] arr = new int[N];
            
            for(int i=0; i<N; i++)
                arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.makeProductOne(arr,N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    
    
    /** 
     *  find the count of positive and negetive number
     *  
     *  
     * */
    
    
    
      static int makeProductOne(int[] arr, int N) {
        // code here
        int neg = 0;
        int pos = 0;
        int count = 0;
        int zero = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i] != 1 && arr[i] != -1) {
                if (arr[i] < 0) {
                    count += (-1 + Math.abs(arr[i]));
                    arr[i] = arr[i] + (-1 + Math.abs(arr[i]));
                    neg++;
                } else if (arr[i] > 0) {
                    count += (arr[i] - 1);
                    arr[i] = arr[i] - (arr[i] - 1);
                    pos++;
                } else {
                    arr[i] = 1;
                    count++;
                    zero++;
                }
            } else if (arr[i] == 1) {
                pos++;
            } else {
                neg++;
            }
        }
        // 4 even sorted 5 <= 7 | 5 sorted
        if (neg <= zero || (neg%2 == 0)) {
            return count;
        }
        
        // neg 5 zero 2
        // 5 = 5 - 4 = 1
        neg = neg - (neg-1);
        if(neg <= zero) return count;
        count = count + 2;
        return count;
    }



};