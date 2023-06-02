class Solution {
    private int findDivisionSum(int[] nums, int divisor) {
        int result = 0;
        for (int num : nums) {
            result += Math.ceil((1.0 * num) / divisor);
        }
        return result;
    }
    
    public int smallestDivisor(int[] nums, int threshold) {
        int ans = -1;
        
        int low = 1;
        int high = nums[0];
        for (int num : nums) {
            high = Math.max(high, num);
        }
        
        while (low <= high) {
            int mid = (low + high) / 2;
            int result = findDivisionSum(nums, mid);
            if (result <= threshold) {
                ans = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        
        return ans;
    }
}