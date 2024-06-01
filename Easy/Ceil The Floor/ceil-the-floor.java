//{ Driver Code Starts
//Initial Template for Java



import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int x = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            Pair ans = new Solve().getFloorAndCeil(arr, n, x);
            System.out.println(ans.floor + " " + ans.ceil);
        }
    }
}

class Pair {
    int floor, ceil;

    Pair() {
        this.floor = 0;
        this.ceil = 0;
    }

    Pair(int floor, int ceil) {
        this.floor = floor;
        this.ceil = ceil;
    }
}

// } Driver Code Ends


//User function Template for Java




class Solve {
    Pair getFloorAndCeil(int[] arr, int n, int x) {
        // code here
        Arrays.sort(arr);
        int l = 0, r = n - 1;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        while(l <= r){
            int mid = (l+r)/2;
            if(arr[mid] == x) return new Pair(arr[mid], arr[mid]);
            else if(arr[mid] < x){
                l = mid+1;
                max = Math.max(max, arr[mid]);
            }else{
                r = mid -1;
                min = Math.min(min, arr[mid]);
            }
        }
        if(min == Integer.MAX_VALUE) min = -1;
        if(max == Integer.MIN_VALUE) max = -1;
        return new Pair(max, min);
        
    }
}

