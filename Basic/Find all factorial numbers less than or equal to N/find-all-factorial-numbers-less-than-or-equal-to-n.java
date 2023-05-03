//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            long N=sc.nextLong();
			
            Solution ob = new Solution();
            ArrayList<Long> ans = ob.factorialNumbers(N);
            for(long num : ans){
                System.out.print(num+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution{
    static ArrayList<Long> factorialNumbers(long N){
        // code here
        ArrayList<Long> list = new ArrayList<Long>();
        long currentFact = 0;
        long i = 1;
        do{
            long fact = 1;
            for(long j=i;j>=1;j--){
                fact *= j;
            }
            currentFact = fact;
            i++;
            if(currentFact <= N){
                list.add(currentFact);
            }else{
                break;
            }
        }while(true);
        return list;
    }
}