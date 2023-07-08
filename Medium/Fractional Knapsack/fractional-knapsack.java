//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}

class GfG {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int w = Integer.parseInt(inputLine[1]);
            Item[] arr = new Item[n];
            inputLine = br.readLine().trim().split(" ");
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Item(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            System.out.println(String.format("%.2f", new Solution().fractionalKnapsack(w, arr, n)));
        }
    }
}
// } Driver Code Ends

/*
class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}
*/

class Solution
    {
        
    double fractionalKnapsack(int W, Item arr[], int n) 
    {
            // // Your code here
        double [][]ratio = new double[n][2];
            
        for(int i=0; i<n; i++){ 
            ratio[i][0] = (double)i;
            ratio[i][1] = (arr[i].value)/(double)(arr[i].weight);
        }
            
        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));
            
        double max_value = 0;
            
        for(int i=ratio.length-1; i>=0; i--){
            int idx = (int)ratio[i][0];
            if(W >= arr[idx].weight){
                max_value += arr[idx].value;
                W -= arr[idx].weight;
            }
            else{
                max_value += ratio[i][1] * W;
                W = 0;
                break;
            }
        }
            
        return max_value;
    }
}