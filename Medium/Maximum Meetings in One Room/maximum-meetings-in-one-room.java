//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);
        
        return a;
    }
    
    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
    
    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int N; 
            N = Integer.parseInt(br.readLine());
            
            
            int[] S = IntArray.input(br, N);
            
            
            int[] F = IntArray.input(br, N);
            
            Solution obj = new Solution();
            ArrayList<Integer> res = obj.maxMeetings(N, S, F);
            
            IntArray.print(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    
    static class meet implements Comparator<meet>{
        int start;
        int end;
        int index;
        meet(){}
        
        meet(int start, int end, int index){
            this.start = start;
            this.end = end;
            this.index = index;
        }
        
        @Override
        public int compare(meet m1,meet m2){
            if(m1.end == m2.end){
                return m1.start - m2.start;
            }
            return m1.end - m2.end;
        }
        
    }
    
    public static ArrayList<Integer> maxMeetings(int N, int[] s, int[] f) {
        List<meet> list = new ArrayList<>();
        for(int i=0;i<N;i++){
            list.add(new meet(s[i],f[i],i+1));            
        }
        ArrayList<Integer> ans = new ArrayList<>();
        Collections.sort(list, new meet());
        int end = 0;

        for(int i=0;i<N;i++){
            if(list.get(i).start > end){
                ans.add(list.get(i).index);
                end = list.get(i).end;
            }
        }
        Collections.sort(ans);
        return ans;
    }
}
        
