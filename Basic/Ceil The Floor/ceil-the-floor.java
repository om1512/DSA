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
    Pair getFloorAndCeil(int[] nums, int n, int target) {
        Arrays.sort(nums);
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int left = 0;
        int right = n - 1;
        int mid = (left + right) / 2;
        while (left <= right) {
          if (nums[mid] == target) {
            return new Pair(nums[mid],nums[mid]);
          } else if (nums[mid] < target) {
            left = mid + 1;
            max = Math.max(max, nums[mid]);
          } else{
            min = Math.min(min,nums[mid]);
            right = mid - 1;
          }
          mid = (left + right) / 2;
        }
        if(min == Integer.MAX_VALUE) min = -1;
        if(max == Integer.MIN_VALUE) max = -1;
        return new Pair(max,min);
    }
}

