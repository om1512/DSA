//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		for(int t=0;t<testCases;t++){
		    int n = sc.nextInt();
		    int arr[] = new int[n];
		    ArrayList<Integer> A = new ArrayList<Integer>();
		    for(int i=0;i<n;i++){
		        arr[i] = sc.nextInt();
		        A.add(arr[i]);
		        
		    }
		   
		   
		    
		    ArrayList <ArrayList<Integer>> res = new Solution().subsets(A);
		    for (int i = 0; i < res.size (); i++)
		    {
		        for (int j = 0; j < res.get(i).size (); j++)
		        {
		          System.out.print(res.get(i).get(j)+" ");
		        }
		        System.out.println();
		      
		    }
		    //System.out.println();
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    private static ArrayList<ArrayList<Integer>> mysubsets(ArrayList<Integer> list, int index, ArrayList<Integer> current,
      ArrayList<ArrayList<Integer>> result) {
    if (index == list.size()) {
      result.add(new ArrayList<>(current));
      return result;
    }
    mysubsets(list, index + 1, current, result);
    current.add(list.get(index));
    mysubsets(list, index + 1, current, result);
    current.remove(current.size() - 1);
    return result;
  }
    public static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A)
    {
        //code here
        Comparator com = new Comparator<ArrayList<Integer>>() {
          public int compare(ArrayList<Integer> a, ArrayList<Integer> b) {
            int min = Math.min(a.size(), b.size());
            for (int i = 0; i < min; i++) {
              if (a.get(i) - b.get(i) != 0) {
                return a.get(i) - b.get(i);
              }
            }
            return a.size() - b.size();
          }
        };
        ArrayList<ArrayList<Integer>> ans = mysubsets(A, 0, new ArrayList<>(), new ArrayList<>());
        Collections.sort(ans, com);
        return ans;
    }
}