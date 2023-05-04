//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(s[i + 1]);
            }
            int k = Integer.parseInt(br.readLine().trim());
            Solution obj = new Solution();
            int[] ans = obj.topK(nums, k);
            for (int i = 0; i < ans.length; i++) System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    public int[] topK(int[] nums, int k) {
        // Code here
        
         int n=nums.length;

        HashMap<Integer,Integer> map= new HashMap<>();

        for(int i=0;i<n;i++){

            map.put(nums[i],map.getOrDefault(nums[i],0)+1);

        }

        List<Map.Entry<Integer,Integer>>list=new ArrayList<Map.Entry<Integer,Integer>>(map.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer> >() {

                public int compare(

                    Map.Entry<Integer, Integer> o1,

                    Map.Entry<Integer, Integer> o2)

                {

                    if (o1.getValue().equals(o2.getValue()))

                        return o2.getKey() - o1.getKey();

                    else

                        return o2.getValue()- o1.getValue();

                }

            });

            int res[]= new int[k];

            for(int i=0;i<k;i++){

                res[i]=list.get(i).getKey();

            }

            return res;
        
    
    }
}