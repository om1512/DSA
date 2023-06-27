//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {

            int N;
            N = sc.nextInt();

            int[] asteroids = new int[N];
            for (int i = 0; i < N; i++) asteroids[i] = sc.nextInt();

            Solution obj = new Solution();
            int[] res = obj.asteroidCollision(N, asteroids);

            for (int e : res) System.out.print(e + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int[] asteroidCollision(int N, int[] asteroids) {
        // code here
        Stack<Integer> stack = new Stack<>();
            for (int i : asteroids) {
                if(i>0 || stack.isEmpty()){
stack.push(i);
                }
            else {
                int data = Math.abs(i);
                while (!stack.isEmpty() && stack.peek() > 0 && data > Math.abs(stack.peek())) {
                stack.pop();
                }
                if(!stack.isEmpty() && stack.peek() == data){
                    stack.pop();
                }else{
                    if(stack.isEmpty() || stack.peek() <0){
stack.push(i);
                    }
                }
            }
            
            }
            int[] ans = new int[stack.size()];
            int index = stack.size() - 1;
            while (!stack.isEmpty()) {
                ans[index--] = stack.pop();
            }
        return ans;
    }
}
