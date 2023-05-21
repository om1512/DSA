class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length,left = 0, right = n-1;
        while(left < right){
            int mid = (left + right)/2;
            if(mid == 0){
                return nums[0] >= nums[1] ? 0 : 1;
            }
            else if(mid == n-1){
                return nums[n-1] >= nums[n-2] ? n-1 : n-2;
            }
            else if(nums[mid] >= nums[mid-1] && nums[mid] >= nums[mid+1]){
                return mid;
            }
            else if(nums[mid] < nums[mid-1]){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return left;
    }
}