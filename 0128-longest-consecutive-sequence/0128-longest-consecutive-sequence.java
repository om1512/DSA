class Solution {
    public int longestConsecutive(int[] nums) {
		int N = nums.length;
		 if(N == 0){
			 return 0;
		 }

     Arrays.sort(nums);
		 
	   int num = nums[0];
	   int count = 1;
	   int max = 1;
	   for(int i=1;i<N;i++){
	       if(nums[i] == num+1){
	           count++;
	       }else if(nums[i] != num){
	           count=1;
	       }
	       max = Math.max(max,count);
	       num = nums[i];
	   }
	   return max;
    }
}