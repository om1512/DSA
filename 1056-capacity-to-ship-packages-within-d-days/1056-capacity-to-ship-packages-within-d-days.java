class Solution {
    static boolean help(int[] n,int ships,int cap){
        int c = cap,s = 1;
        for(int i:n){
            if(c-i<0){
                s++;
                c = cap;
            }
            c-=i;
        }
        return (s<=ships);
    }
    public int shipWithinDays(int[] weights, int days) {
        int low= Integer.MIN_VALUE,high = 0;
        for(int i:weights){
            low  = Math.max(low,i);
            high += i;
        }
        int ans = high;
        while(low<=high){
            int mid = (low+high)/2;
            if(help(weights,days,mid)){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }
}