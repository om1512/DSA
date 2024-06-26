//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {
    long findSwapValues(long a[], int n, long b[], int m) {
        // Your code goes here
        long sumA = Arrays.stream(a).sum();
        long sumB = Arrays.stream(b).sum();
        if(sumA == sumB) return 1;
        Arrays.sort(a);
        Arrays.sort(b);
        long diff = sumA - sumB;
        if((diff) % 2 != 0) return -1;
        diff /= 2;

        // Use a HashSet to store all elements from array a for quick lookup.
        HashSet<Long> setA = new HashSet<>();
        for (long num : a) {
            setA.add(num);
        }

        // Check for each element in array b if there's an element in array a
        // that can be swapped to balance the sums.
        for (long num : b) {
            // If setA contains (num + diff), swapping num from b with (num + diff) from a
            // will balance the sums of the two arrays.
            if (setA.contains(num + diff)) {
                return 1;
            }
        }

        // If no such pair is found, return -1.
        return -1;
    }

}


//{ Driver Code Starts.

// Driver class
class Array {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while (testcases-- > 0) {
            String line = br.readLine();
            String[] q = line.trim().split("\\s+");
            int n = Integer.parseInt(q[0]);
            int m = Integer.parseInt(q[1]);
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            long a[] = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(a1[i]);
            }
            String line2 = br.readLine();
            String[] a2 = line2.trim().split("\\s+");
            long b[] = new long[m];
            for (int i = 0; i < m; i++) {
                b[i] = Long.parseLong(a2[i]);
            }
            Solution ob = new Solution();
            long ans = ob.findSwapValues(a, n, b, m);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends