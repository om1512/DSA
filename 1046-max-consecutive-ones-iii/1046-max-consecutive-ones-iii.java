class Solution {
    public int longestOnes(int[] nums, int k) {
        int flip = 0;
        int n = nums.length;
        int i =0, j =0;
        int ans = 0;
        while(i<n){
            if(nums[i] == 0){
                flip++;
            }
            while(flip>k){
                if(nums[j] == 0) flip--;
                j++;
            }
            ans = Math.max(ans,i-j+1);
            i++;
        }
        return ans;
    }
}