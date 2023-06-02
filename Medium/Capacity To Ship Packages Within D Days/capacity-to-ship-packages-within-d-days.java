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
            
            int D = Integer.parseInt(read.readLine());
            
            for(int i=0; i<N; i++)
                arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.leastWeightCapacity(arr,N,D));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static boolean help(int[] n,int ships,int cap){
        int c = cap,s = 1;
        for(int i:n){
            if(c-i<0){
                s++;
                c = cap;
            }
            c-=i;
        }
        return (s<=ships);
    }
    static int leastWeightCapacity(int[] weights, int N, int days) {
        int low= Integer.MIN_VALUE,high = 0;
        for(int i:weights){
            low  = Math.max(low,i);
            high += i;
        }
        int ans = high;
        while(low<=high){
            int mid = (low+high)/2;
            if(help(weights,days,mid)){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }
};