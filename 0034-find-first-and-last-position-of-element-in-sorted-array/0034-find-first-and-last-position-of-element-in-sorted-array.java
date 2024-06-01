class Solution {
    public int[] searchRange(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while(l<=r){
            int mid =(l+r) /2;
            if(nums[mid] == target){
                int right = mid;
                int left = mid;
                while(left - 1 >= 0 && target == nums[left - 1]) left--;
                while(right + 1 < nums.length && target == nums[right + 1]) right++;
                return new int[]{left, right};
            }else if(nums[mid] < target){
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        return new int[]{-1, -1};
    }
}