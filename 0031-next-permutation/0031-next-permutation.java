class Solution {

    public void swap(int[] nums, int i, int j){
        while(i <= j){
            int tem = nums[i];
            nums[i] = nums[j];
            nums[j] = tem;
            i++;
            j--;
        }
    }
    public void nextPermutation(int[] nums) {
        // find pivot index
        int n = nums.length;
        if(n-2 < 0) return;
        int pivotIndex = -1;
        for(int i=n - 2; i>=0;i--){
            if(nums[i] < nums[i+1]){ 
                pivotIndex = i;
                break;
            }
        }
        if(pivotIndex != -1){
            for(int i=n - 1; i>pivotIndex;i--){
                if(nums[i] > nums[pivotIndex]){ 
                    int tem = nums[pivotIndex];
                    nums[pivotIndex] = nums[i];
                    nums[i] = tem;
                    break;
                }
            }
        }
        swap(nums, pivotIndex + 1, n - 1);
    }
}