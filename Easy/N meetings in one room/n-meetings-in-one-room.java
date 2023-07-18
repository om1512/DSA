//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);

            int start[] = new int[n];
            int end[] = new int[n];

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++)
                start[i] = Integer.parseInt(inputLine[i]);

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) 
                end[i] = Integer.parseInt(inputLine[i]);
                
            int ans = new Solution().maxMeetings(start, end, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution 
{
        static class job implements Comparable<job> {
          int start;
          int end;
        
          job(int start, int end) {
            this.start = start;
            this.end = end;
          }
        
          @Override
          public int compareTo(job o1) {
            return this.end - o1.end;
          }
        
        }
    
      public static int maxMeetings(int start[], int end[], int n) {
        ArrayList<job> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
          list.add(new job(start[i], end[i]));
        }
        Collections.sort(list);
        int count = 0;
        int prevEnd = -1;
        for(job j:list){
          if(j.start > prevEnd){
            count++;
            prevEnd = j.end;
          }
        }
        return count;
    }
}
