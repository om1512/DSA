class Solution {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int prev = nums[0];
        int move = 0;
        for(int i=1;i<nums.length;i++){
            if(nums[i] <= prev){
                move += (prev + 1 - nums[i]);
                nums[i] = prev + 1;
            }
            prev = nums[i];
        }
        return move;
    }
}

// 1 1 2 2 3 7 
// 1 2 3 4 5 7

// 1 1 2 2 0