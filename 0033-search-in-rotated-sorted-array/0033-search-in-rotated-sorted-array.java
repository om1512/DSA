class Solution {
    public int search(int[] nums, int t) {
        int n = nums.length, left = 0, right = n - 1,mid = (left+right)/2;
        while (left <= right) {
            mid = (left+right)/2;
            if(nums[mid] == t){
                return mid;
            }
            if(nums[left] <= nums[mid]){
                if(nums[left] <= t && nums[mid] >= t){
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }else{
                if(nums[mid] <= t && nums[right] >= t){
                    left = mid+1;
                }else{
                    right = mid-1;
                }
            }
        }
        return -1;
    }
}