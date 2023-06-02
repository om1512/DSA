class Solution {
    static boolean isPossible(int[] arr,int b,int f,int mid)
    {
        int bc = 0, adj = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i] <= mid){
                adj++;
                if(adj == f){
                    bc++;
                    if(bc  == b){
                        return true;
                    }
                    adj = 0;
                }
            }
            else{
                adj = 0;
            }
        }
        return false;

    }
    public int minDays(int[] bloomDay, int m, int k) {
        int low = Integer.MAX_VALUE,high = Integer.MIN_VALUE;
        int ans = -1;
        for(int b:bloomDay){
            low = Math.min(low,b);
            high = Math.max(high,b);
        }
        while(low<=high){
            int mid = (low+high)/2;
            if(isPossible(bloomDay,m,k,mid)){
                ans = mid;
                high  = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }
}