class Solution {
    public int maxProduct(int[] nums) {
       int suf = 1,pre = 1,max = Integer.MIN_VALUE,n  = nums.length;
       for(int i=0;i<n;i++){
           if(suf == 0) suf = 1;
           if(pre == 0) pre = 1;
           suf *= nums[i];
           pre *= nums[n-i-1];
           max = Math.max(max,Math.max(pre,suf));
       }
       return max;
    }
}