class Solution {
    public int findMin(int[] nums) {
        int mid = nums[nums.length / 2];
        int r = nums.length / 2;
        int l = 0;
        if(mid > nums[nums.length - 1]){
            l = nums.length / 2;
            r = nums.length - 1;
        }
        while(l<=r){
            int m = (l+r)/2;
            if(nums[m]<mid){
                mid = nums[m];
                r = m-1;
            }else{
                l = m+1;
            }
        }
        return mid;
    }
}