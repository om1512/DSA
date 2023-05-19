class Solution {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            int m = 1;
            for(int j=i;j<nums.length;j++){
                m *= nums[j];
                if(max < m){
                    max = m;
                }
            }
        }
        return max;
    }
}