//{ Driver Code Starts
import java.util.*;

class Find_Given_Element_Of_Spiral_Matrix 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0)
		{
			int n = sc.nextInt();
			int m = sc.nextInt();
			int k = sc.nextInt();
			int arr[][] = new int[n][m];
			for(int i=0; i<n; i++)
			{
				for(int j=0; j<m; j++ )
				{
					arr[i][j] = sc.nextInt();
				}
			}
			Solution obj = new Solution();
			System.out.println(obj.findK(arr, n, m, k));
		t--;
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
   
	public int findK(int a[][], int n, int m, int k)
	{
	    List<Integer> l = new ArrayList<Integer>();
        int left = 0,right = m-1;
        int bottom = n-1,top = 0;

        while(left<=right && top<=bottom){
            //right
            for(int i=left;i<=right;i++){
                l.add(a[top][i]);
            }
            top++;

            //down
            for(int i=top;i<=bottom;i++){
                l.add(a[i][right]);
            }
            right--;

            //right
            if(top<=bottom){
                for(int i=right;i>=left;i--){
                    l.add(a[bottom][i]);
                }
                bottom--;
            }

            //above
            if(left<=right){
                for(int i=bottom;i>=top;i--){
                    l.add(a[i][left]);
                }
                left++;
            }
        }

        return l.get(k-1);
	}
	
}