//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String[] s = br.readLine().trim().split(" ");
            int[][] Intervals = new int[n][2];
            int j = 0;
            for(int i = 0; i < n; i++){
                Intervals[i][0] = Integer.parseInt(s[j]);
                j++;
                Intervals[i][1] = Integer.parseInt(s[j]);
                j++;
            }
            Solution obj = new Solution();
            int[][] ans = obj.overlappedInterval(Intervals);
            for(int i = 0; i < ans.length; i++){
                for(j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends

class task implements Comparable<task>{
  int start;
  int end;
  task(int start,int end){
    this.start = start;
    this.end = end;
  }

  @Override
  public int compareTo(task o) {
    return this.start-o.start;
  }
}
class Solution
{
    public int[][] overlappedInterval(int[][] Intervals)
    {
        
    List<task> l = new ArrayList<>();
    for(int[] a:Intervals){
      l.add(new task(a[0],a[1]));
    }
    Map<Integer,Integer> m = new LinkedHashMap<>();
    Collections.sort(l);
    int preEnd = Integer.MIN_VALUE;
    int  preStart = 0;
     for(task t : l){
      if(t.start > preEnd){
        m.put(t.start,t.end);
        preStart = t.start;
        preEnd = t.end;
      }else{
        if(preEnd<t.end){
          m.put(preStart,t.end);
          preEnd = t.end;
        }else{
          m.put(preStart,preEnd);
        }
      }
     
      
    }
        int[][] ans = new int[m.size()][2];
        int index = 0;
        for(Map.Entry<Integer, Integer> e:m.entrySet()){
        ans[index][0] = e.getKey();
        ans[index][1] = e.getValue();
        index++;
        }
        return ans;
    }
}