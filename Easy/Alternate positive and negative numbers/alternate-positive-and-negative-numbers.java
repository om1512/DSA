//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            new Solution().rearrange(arr, n);
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java




class Solution {
    void rearrange(int arr[], int n) {
        // code here
        int length = arr.length;
        List<Integer> positive = new ArrayList<>();
        List<Integer> negetive = new ArrayList<>();
        for(int i:arr){
            if(i < 0) negetive.add(i);
            else positive.add(i);
        }
        int i = 0;
        int index = 0;

        while(index < positive.size() && index < negetive.size()){
            arr[i] = positive.get(index);
            arr[i+1] = negetive.get(index);
            index++;
            i+=2;
        }
        
        while(index < positive.size()){
            arr[i++] = positive.get(index++);
        }
        
        while(index < negetive.size()){
            arr[i++] = negetive.get(index++);
        }
    }
}