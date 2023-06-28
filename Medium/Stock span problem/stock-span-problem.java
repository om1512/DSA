//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n =sc.nextInt();
            int a[] = new int[n];
            
            int i = 0;
            for(i = 0; i < n; i++)
              a[i] = sc.nextInt();
              
            int[] s = new Solution().calculateSpan(a, n);
            
            for(i = 0; i < n; i++)
            {
                System.out.print(s[i] + " ");
            }
            
            System.out.println();
        }
    }
    
    
    
}
// } Driver Code Ends



class Solution
{
    
    class Pair {
        int a;
        int b;
    
        Pair(int a, int b) {
          this.a = a;
          this.b = b;
        }
      }
    //Function to calculate the span of stockâ€™s price for all n days.
    public  int[] calculateSpan(int price[], int n)
    {
        int[] ans = new int[n];
        Stack<Pair> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
          int span = 1;
          while (!stack.isEmpty() && stack.peek().a <= price[i]) {
            span += stack.peek().b;
            stack.pop();
          }
          stack.push(new Pair(price[i], span));
          ans[i] = span;
        }
        return ans;
    }
    
}