class Solution {
    int ans = Integer.MAX_VALUE;
    void backTrack(int i,int[] cookies,int n,int[] dis){
        int max = 0;
        if(i == n){
            for(int data:dis){
                max = Math.max(max,data);
            }
            ans = Math.min(ans,max);
            return;
        } 
        if(ans <= max) return;
        for(int j=0;j<dis.length;j++){
            dis[j] += cookies[i];
            backTrack(i+1,cookies,n,dis);
            dis[j] -= cookies[i];
        }
    }
    public int distributeCookies(int[] cookies, int k) {
        int[] dis = new int[k];
        int n = cookies.length;
        backTrack(0,cookies,n,dis);
        return ans;
    }
}