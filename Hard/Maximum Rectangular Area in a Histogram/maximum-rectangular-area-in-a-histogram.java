//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    long n = Long.parseLong(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    long[] arr = new long[(int)n];
		    for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
		    System.out.println(new Solution().getMaxArea(arr, n));
		}
	}
}




// } Driver Code Ends


class Solution
{
    //Function to find largest rectangular area possible in a given histogram.
   
        // your code here
      class Pair {
        long a;
        long b;
        Pair(long a, long b) {
          this.a = a;
          this.b = b;
        }
      }

     public long[] leftSmall(long[] arr) {
        long[] ans = new long[arr.length];
        Stack<Pair> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
          while (!stack.isEmpty() && stack.peek().a >= arr[i]) {
            stack.pop();
          }
          if (!stack.isEmpty())
            ans[i] = stack.peek().b + 1;
          else
            ans[i] = 0;
          stack.push(new Pair(arr[i], i));
        }
        return ans;
  }

  public long[] rightSmall(long[] arr) {
    long[] ans = new long[arr.length];
    Stack<Pair> stack = new Stack<>();
    for (int i = arr.length-1; i>=0 ; i--) {
      while (!stack.isEmpty() && stack.peek().a >= arr[i]) {
        stack.pop();
      }
      if (!stack.isEmpty())
        ans[i] = stack.peek().b - 1;
      else
        ans[i] = arr.length-1;
      stack.push(new Pair(arr[i], i));
    }
    return ans;
  }

     public long getMaxArea(long heights[], long n) 
    {
        if (heights.length == 1)
        return heights[0];

        long[] left = leftSmall(heights);
        long[] right = rightSmall(heights);
        long ans = 0;
        for (int i = 0; i < heights.length; i++) {
        long width = (right[i] - left[i]) + 1;
            ans = Math.max(ans, width * heights[i]);
        }
        return ans;
    }
        
}



