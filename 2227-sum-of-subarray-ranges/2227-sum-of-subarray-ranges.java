class Solution {
    public long subArrayRanges(int[] nums) {
        long ans = 0;
    for(int i=0;i<nums.length;i++){
      int min = nums[i],max = nums[i];
      for(int j=i+1;j<nums.length;j++){
        if(nums[j] > max) max = nums[j];
        if(nums[j] < min) min = nums[j];
        ans += (max-min);
      }
    }      
    return ans;
    }
}