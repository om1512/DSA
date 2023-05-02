//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            Long A = Long.parseLong(S[0]);
            Long B = Long.parseLong(S[1]);

            Solution ob = new Solution();
            Long[] ptr = ob.lcmAndGcd(A,B);
            
            System.out.print(ptr[0]);
            System.out.print(" ");
            System.out.println(ptr[1]);
        }
    }
}
// } Driver Code Ends


class Solution {
    static Long[] lcmAndGcd(Long A , Long B) {
        Long[] ans = new Long[2];
        Long Num1 = A;
        Long Num2 = B;
        while(Num2 != 0)  
        {  
        Long Temp = Num2;  
        Num2 = Num1 % Num2;  
        Num1 = Temp;  
        }  
        Long lcm = (A*B)/Num1;
        ans[0] = lcm;
        ans[1] = Num1;
        return ans;
    }   
};