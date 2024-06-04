class Solution {
    // using Recusion + memo
    public boolean solve(int[] nums, int index, Boolean[] dp){
        if(index == nums.length - 1){
            return true;
        }
        if(index >= nums.length) return false;
        if(dp[index] != null) return dp[index];
        boolean ans = false;
        for(int i=0;i<nums[index];i++){
            ans = (ans || solve(nums, index + i + 1, dp));
        }
        return dp[index] = ans;
    }


    public boolean canJump(int[] nums) {
        Boolean[] dp = new Boolean[nums.length];
        Arrays.fill(dp, null);
        return solve(nums, 0, dp);
    }
}